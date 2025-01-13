package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URLEncoder;

@Controller
@RequestMapping("/login")
public class LoginController {

//    @RequestMapping("/login/login")
//    @RequestMapping("/login/login", method=RequestMethod.GET)
//    @GetMapping("/login/login")
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

//    @RequestMapping(value = ="login/login", method= {RequestMethod.GET, RequestMethod.POST})

//    @RequestMapping(value="login/login", method= RequestMethod.POST)
//    @PostMapping("/login/login")
    @PostMapping("/login")
    public String login(String id, String pwd, Model model) throws Exception {
        // 1. id, pwd 확인
        if (loginCheck(id, pwd)) {
            // 2-1. 일치하면, userInfo.html
            model.addAttribute("id", id);
            model.addAttribute("pwd", pwd);
            return "userInfo";
        }
        else {
            // 2-2. 일치하지 않으면, login.html로 돌아가기
            String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "utf-8");
            return "redirect:/login/login?msg=" + msg;
        }
    }

    private boolean loginCheck(String id, String pwd) {
        return id.equals("asdf") && pwd.equals("1234");
    }
}
