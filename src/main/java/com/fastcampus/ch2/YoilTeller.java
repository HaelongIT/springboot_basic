package com.fastcampus.ch2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

// 년월일을 입력하면 요일을 알려주는 원격 프로그램
// 프로그램 등록
@Controller
public class YoilTeller {

    // 프로그램과 URL 연결
    @RequestMapping("/getYoil")
    public String main(int year, int month, int day, Model model) throws IOException {

        // 2. 작업 - 요일을 계산
        Calendar cal = Calendar.getInstance();      // 현재 날짜와 시간을 가져오기
        cal.clear();                                // cal의 모든 필드 초기화
        cal.set(year, month-1, day);        // 월은 0-11로 들어가야 됨(-1이 필요)

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);  // 요일을 1~7을 반환(DAY_OF_WEEK)
        char yoil = "일월화수목금토".charAt(dayOfWeek-1);  // 1~7을 0~6으로 변환 필요

        // 작업한 결과를 Model에 저장(DS가 Model을 View로 전달)
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("yoil", yoil);

        return "yoil";      // 뷰의 이름을 반환
    }

    @RequestMapping("/yoil")
    public void main2(int year, int month, int day, Model model) throws IOException {

        // 2. 작업 - 요일을 계산
        Calendar cal = Calendar.getInstance();      // 현재 날짜와 시간을 가져오기
        cal.clear();                                // cal의 모든 필드 초기화
        cal.set(year, month-1, day);        // 월은 0-11로 들어가야 됨(-1이 필요)

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);  // 요일을 1~7을 반환(DAY_OF_WEEK)
        char yoil = "일월화수목금토".charAt(dayOfWeek-1);  // 1~7을 0~6으로 변환 필요

        // 작업한 결과를 Model에 저장(DS가 Model을 View로 전달)
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("yoil", yoil);
    }

    @RequestMapping("/yoil2")
    public ModelAndView main3(int year, int month, int day) throws IOException {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("yoilError");

        if (!isVaild(year, month, day)) {
            return mv;      // 사용자가 요청한 날짜가 유효하지 않으면 yoilError를 보여줌
        }

        // 2. 작업 - 요일을 계산
        Calendar cal = Calendar.getInstance();      // 현재 날짜와 시간을 가져오기
        cal.clear();                                // cal의 모든 필드 초기화
        cal.set(year, month-1, day);        // 월은 0-11로 들어가야 됨(-1이 필요)

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);  // 요일을 1~7을 반환(DAY_OF_WEEK)
        char yoil = "일월화수목금토".charAt(dayOfWeek-1);  // 1~7을 0~6으로 변환 필요

        // 작업한 결과를 Model에 저장(DS가 Model을 View로 전달)
        mv.addObject("year", year);
        mv.addObject("month", month);
        mv.addObject("day", day);
        mv.addObject("yoil", yoil);
        mv.setViewName("yoil");     // 정상 작업했으면 뷰 이름을 변경해서 반환

        return mv;      // ModelAndView를 반환
    }

    private boolean isVaild(int year, int month, int day) {
        // 년 월 일에 대해서 유효한 값들이 들어왔는지 검증하는 단계 필요
        return true;
    }
}
