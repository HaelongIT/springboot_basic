package com.fastcampus.ch2;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class PerformanceFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 전처리
        long startTime = System.currentTimeMillis();

        // 서블릿/필터 호출
        filterChain.doFilter(servletRequest, servletResponse);

        // 후처리
        long endTime = System.currentTimeMillis();
        System.out.print("[" + ((HttpServletRequest) servletRequest).getRequestURI() +
                "]");
        System.out.println("soyoTime = " + (endTime - startTime));
    }
}
