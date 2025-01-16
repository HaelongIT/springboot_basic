package com.fastcampus.ch2;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String main() {
//        System.out.println("확인" + req.getAttribute("msg"));

        return "index";
    }
}
