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
        log.info("name:"+userName);
        log.info("passwrod:"+userPwd);
        User user=userService.login(userName,userPwd);
        if (user==null||user.getName().equalsIgnoreCase("")){
            log.warn("用户name="+userName+"尝试登录失败");
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
        httpSession.invalidate();
        return "login";

    }
    @RequestMapping("/editpassword")
    public String editPassword(HttpSession httpSession,String userName,String userPwd1,String userPwd2,Model model){
        if (httpSession.getAttribute("name")==null||httpSession.getAttribute("name").toString().equalsIgnoreCase("")){
            return "login";
        }
        User user=userService.login(userName,userPwd1);
        if (user==null){
            log.info("原密码校验错误");
            model.addAttribute("name",httpSession.getAttribute("name"));
            model.addAttribute("sBeginDate", NowDate.getNowDate());
            model.addAttribute("sEndDate", NowDate.getNowDate());
            return "main";
        }
        user.setPassword(userPwd2);
        if (userService.updateUser(user)>0){
            log.info("密码修改成功");
        }else{
            log.info("密码修改失败");
        }
        model.addAttribute("name",httpSession.getAttribute("name"));
        model.addAttribute("sBeginDate", NowDate.getNowDate());
        model.addAttribute("sEndDate", NowDate.getNowDate());
        return "main";

    }
}
