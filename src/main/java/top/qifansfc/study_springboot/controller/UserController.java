package top.qifansfc.study_springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.qifansfc.study_springboot.domain.User;
import top.qifansfc.study_springboot.service.UserService;
import top.qifansfc.study_springboot.util.NowDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户登录，修改密码，退出控制器
 */
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public String login(HttpSession httpSession, String userName, String userPwd, Model model){
//        String userName=request.getParameter("uname");
//        String userPwd=request.getParameter("upassword");
        User user=userService.login(userName,userPwd);
        if (user==null||user.getName().equalsIgnoreCase("")){
            log.warn("用户name="+userName+"尝试登录失败");
            model.addAttribute("msg", "用户名不存在或密码错误");
            return "login";
        }else{
            log.info("用户name="+userName+"登录成功");
            httpSession.setAttribute("id",user.getId());
            httpSession.setAttribute("name",user.getName());
            model.addAttribute("name",httpSession.getAttribute("name"));
            model.addAttribute("sBeginDate", NowDate.getNowDate());
            model.addAttribute("sEndDate", NowDate.getNowDate());
            return "main";
        }
    }
    @RequestMapping("/logout")
    public String logout(HttpSession httpSession){
        log.info("用户name="+httpSession.getAttribute("name")+"退出");
        httpSession.invalidate();
        return "login";

    }
    @RequestMapping("/xiugai")
    public String editPassword(HttpSession httpSession,String userPwd,String newUserPwd1,Model model){
        if (httpSession.getAttribute("name")==null||httpSession.getAttribute("name").toString().equalsIgnoreCase("")){
            return "login";
        }
        User user=userService.login(httpSession.getAttribute("name").toString(),userPwd);
        if (user==null){
            log.info("用户name="+httpSession.getAttribute("name")+"尝试修改密码，原密码错误");
            model.addAttribute("msg", "原密码校验错误");
            model.addAttribute("name",httpSession.getAttribute("name"));
            model.addAttribute("sBeginDate", NowDate.getNowDate());
            model.addAttribute("sEndDate", NowDate.getNowDate());
            return "xiugai";
        }
        user.setPassword(newUserPwd1);
        if (userService.updateUser(user)>0){
            log.info("用户name="+httpSession.getAttribute("name")+"修改密码成功");
        }else{
            log.info("用户name="+httpSession.getAttribute("name")+"修改密码失败");
        }
        model.addAttribute("name",httpSession.getAttribute("name"));
        model.addAttribute("sBeginDate", NowDate.getNowDate());
        model.addAttribute("sEndDate", NowDate.getNowDate());
        return "main";

    }
}
