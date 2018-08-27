package top.qifansfc.study_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
@Controller
public class GotoController {
    @RequestMapping("/")
    public String index(HttpSession httpSession, Model model){
        String result="main";
        String sname=null;
        if (httpSession.getAttribute("name")!=null){
            sname=httpSession.getAttribute("name").toString();
            model.addAttribute("name",sname);
        }
        //如果未登录
        if (sname==null||sname.equalsIgnoreCase("")){
            result="login";
        }
        return result;
    }
    @RequestMapping("/gotoeditpassword")
    public String gotoEditPassword(){
        return "editpassword";

    }
}
