package com.fastcampus.ch2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class PerfomanceInterceptor implements HandlerInterceptor {

//    long startTime;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 전처리 작업
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);

        HandlerMethod method = (HandlerMethod) handler;
        System.out.println("method.getMethod() = " + method.getMethod());
        System.out.println("method.getBean() = " + method.getBean());

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 후처리 작업
        long startTime = (long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        System.out.print("[" + ((HttpServletRequest) request).getRequestURI() +
                "]");
        System.out.println("soyoTime = " + (endTime - startTime));
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
