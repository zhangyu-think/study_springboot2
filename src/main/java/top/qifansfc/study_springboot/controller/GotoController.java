package top.qifansfc.study_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.qifansfc.study_springboot.util.NowDate;

import javax.servlet.http.HttpSession;

/**
 * 公用转向控制器
 */
@Controller
public class GotoController {
    @RequestMapping("/")
    public String index(HttpSession httpSession, Model model){
        String result="main";
        String sname=null;
        if (httpSession.getAttribute("name")!=null){
            sname=httpSession.getAttribute("name").toString();
            model.addAttribute("name",sname);
            model.addAttribute("sBeginDate", NowDate.getNowDate());
            model.addAttribute("sEndDate", NowDate.getNowDate());
        }
        //如果未登录
        if (sname==null||sname.equalsIgnoreCase("")){
            result="login";
        }
        return result;
    }
    @RequestMapping("/gotomain")
    public String gotoMain(HttpSession httpSession,Model model){
        if (httpSession.getAttribute("name")==null||httpSession.getAttribute("name").toString().equalsIgnoreCase("")){
            return "login";
        }
        model.addAttribute("sBeginDate", NowDate.getNowDate());
        model.addAttribute("sEndDate", NowDate.getNowDate());
        return "main";
    }

    @RequestMapping("/gotoxiugai")
    public String xiugai(HttpSession httpSession){
        if (httpSession.getAttribute("name")==null||httpSession.getAttribute("name").toString().equalsIgnoreCase("")){
            return "login";
        }
        return "xiugai";
    }
}
