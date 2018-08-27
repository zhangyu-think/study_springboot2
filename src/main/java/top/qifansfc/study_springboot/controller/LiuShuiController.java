package top.qifansfc.study_springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.qifansfc.study_springboot.domain.LiuShui;
import top.qifansfc.study_springboot.service.LiuShuiService;
import top.qifansfc.study_springboot.util.ExcelData;
import top.qifansfc.study_springboot.util.ExcelUtils;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class LiuShuiController {
    List<LiuShui> liuShuis=new ArrayList<LiuShui>();
    @Autowired
    LiuShuiService liuShuiService;
    @RequestMapping("/chaxun")
    public String chaXun(HttpSession httpSession,HttpServletResponse response,Model model, String beginDate, String endDate){
        if (httpSession.getAttribute("name")==null||httpSession.getAttribute("name").toString().equalsIgnoreCase("")){
            return "login";
        }
        model.addAttribute("name",httpSession.getAttribute("name"));
        liuShuis=liuShuiService.getLiuShui(beginDate,endDate);
        model.addAttribute("liushuis",liuShuis);
        model.addAttribute("sBeginDate",beginDate);
        model.addAttribute("sEndDate",endDate);
        return "main";
    }
    @RequestMapping("/downloadexcel")
    public void downLoadExcel(HttpSession httpSession,HttpServletResponse response, Model model) throws Exception{
//        log.info("接收到下载请求beginDate="+beginDate+",endDate="+endDate);
        if (httpSession.getAttribute("name")==null||httpSession.getAttribute("name").toString().equalsIgnoreCase("")){
            return;
        }
        model.addAttribute("name",httpSession.getAttribute("name"));
        ExcelData data = new ExcelData();
        data.setName("hello");
        List<String> titles = new ArrayList();
        titles.add("交易日期");
        titles.add("名称");
        titles.add("账号");
        titles.add("金额");
        data.setTitles(titles);
        List<List<Object>> rows = new ArrayList();
        //List<LiuShui> liushuis=liuShuiService.getLiuShui(beginDate,endDate);
//        List<LiuShui> liushuis=liuShuiService.getLiuShui("2018-08-25","2018-08-25");
        for (LiuShui liushui:liuShuis) {
            List<Object> row = new ArrayList<>();
            row.add(liushui.getJyrq());
            row.add(liushui.getName());
            row.add(liushui.getAccount());
            row.add(liushui.getAmount());
            rows.add(row);
        }
        data.setRows(rows);
        SimpleDateFormat fdate=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String fileName=fdate.format(new Date())+".xlsx";
        ExcelUtils.exportExcel(response,fileName,data);

    }


}
