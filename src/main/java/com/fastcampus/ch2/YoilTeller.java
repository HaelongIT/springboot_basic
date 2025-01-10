package com.fastcampus.ch2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

// 년월일을 입력하면 요일을 알려주는 원격 프로그램
// 프로그램 등록
@Controller
public class YoilTeller {

    // 프로그램과 URL 연결
    @RequestMapping("/getYoil")
    public String main(@ModelAttribute MyData myData, Model model) throws IOException {

        // 2. 작업 - 요일을 계산
        char yoil = getYoil(myData);

        // 작업한 결과를 Model에 저장(DS가 Model을 View로 전달)
//        model.addAttribute("myData", myData);

//        model.addAttribute("year", myData.getYear());
//        model.addAttribute("month", myData.getMonth());
//        model.addAttribute("day", myData.getDay());

//        model.addAttribute("yoil", yoil);

        return "yoil";      // 뷰의 이름을 반환
    }

    @ModelAttribute("yoil")
    private static char getYoil(MyData myData) {
        Calendar cal = Calendar.getInstance();      // 현재 날짜와 시간을 가져오기
        cal.clear();                                // cal의 모든 필드 초기화
        cal.set(myData.getYear(), myData.getMonth()-1, myData.getDay());        // 월은 0-11로 들어가야 됨(-1이 필요)

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);  // 요일을 1~7을 반환(DAY_OF_WEEK)
        char yoil = "일월화수목금토".charAt(dayOfWeek-1);  // 1~7을 0~6으로 변환 필요
        return yoil;
    }
}
