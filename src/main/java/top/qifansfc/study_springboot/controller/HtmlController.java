package top.qifansfc.study_springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/html")
public class HtmlController {
    @RequestMapping("/hello")
    public String hello(Model model){
        log.debug("接收到hello请求");
        model.addAttribute("name","张玉");
        return "user/hello";
    }
}
