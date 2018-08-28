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

/**
 * 查询流水控制器
 */
@Slf4j
@Controller
public class LiuShuiController {
    List<LiuShui> liuShuis=new ArrayList<LiuShui>();
    @Autowired
    LiuShuiService liuShuiService;
    @RequestMapping("/chaxun")
    public String chaXun(HttpSession httpSession,Model model, String beginDate, String endDate){
        log.info("接收到查询请求beginDate="+beginDate+",endDate="+endDate);
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
        log.info("导出所见至excel");
        if (httpSession.getAttribute("name")==null||httpSession.getAttribute("name").toString().equalsIgnoreCase("")){
            return;
        }
        model.addAttribute("name",httpSession.getAttribute("name"));
        ExcelData data = new ExcelData();
        data.setName("sheet1");
        List<String> titles = new ArrayList();
        titles.add("商户编号");
        titles.add("POS终端号");
        titles.add("交易日期");
        titles.add("卡号");
        titles.add("交易金额");
        titles.add("商户手续费");
        titles.add("发卡方手续费");
        titles.add("收单方手续费");
        data.setTitles(titles);
        List<List<Object>> rows = new ArrayList();
        for (LiuShui liushui:liuShuis) {
            List<Object> row = new ArrayList<>();
            row.add(liushui.getShhudm());
            row.add(liushui.getZdbsma());
            row.add(liushui.getJioyrq());
            row.add(liushui.getKahaoo());
            row.add(liushui.getJioyje());
            row.add(liushui.getShssfe());
            row.add(liushui.getFkfsxf());
            row.add(liushui.getSdfsxf());
            rows.add(row);
        }
        data.setRows(rows);
        SimpleDateFormat fdate=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String fileName=fdate.format(new Date())+".xlsx";
        ExcelUtils.exportExcel(response,fileName,data);
    }
}
