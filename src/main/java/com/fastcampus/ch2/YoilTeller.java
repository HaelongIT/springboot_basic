package com.fastcampus.ch2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

// 년월일을 입력하면 요일을 알려주는 원격 프로그램
// 프로그램 등록
@RestController
public class YoilTeller {

    // 프로그램과 URL 연결
    @RequestMapping("/getYoil")
    public void main(int year, int month, int day,
                       HttpServletResponse response) throws IOException {

        // 2. 작업 - 요일을 계산
        Calendar cal = Calendar.getInstance();      // 현재 날짜와 시간을 가져오기
        cal.clear();                                // cal의 모든 필드 초기화
        cal.set(year, month-1, day);        // 월은 0-11로 들어가야 됨(-1이 필요)

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);  // 요일을 1~7을 반환(DAY_OF_WEEK)
        char yoil = "일월화수목금토".charAt(dayOfWeek-1);  // 1~7을 0~6으로 변환 필요

        // 3. 출력 - 작업 결과를 브라우저에 전송
        response.setCharacterEncoding("ms949");     // 인코딩 지정

        PrintWriter out = response.getWriter();     // 출력 스트림 얻어오기
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("year = " + year);
        out.println("month = " + month);
        out.println("day = " + day);
        out.println("yoil = " + yoil);
        out.println("</body>");
        out.println("</html>");
    }
}
