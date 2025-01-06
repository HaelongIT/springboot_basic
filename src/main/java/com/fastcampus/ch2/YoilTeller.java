package com.fastcampus.ch2;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 년월일을 입력하면 요일을 알려주는 원격 프로그램
// 프로그램 등록
@RestController
public class YoilTeller {

    // 프로그램과 URL 연결
    @RequestMapping("/getYoil")
    public String main(HttpServletRequest request) {
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");

        System.out.println("year = " + year);
        System.out.println("month = " + month);
        System.out.println("day = " + day);
        return "Monday";
    }
}
