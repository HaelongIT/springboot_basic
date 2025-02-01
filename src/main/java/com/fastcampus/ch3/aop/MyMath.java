package com.fastcampus.ch3.aop;

import org.springframework.stereotype.Component;

@Component
public class MyMath {
    int add(int a, int b) {
        int result = a + b;
        return result;
    }

    int add(int a, int b, int c) {
        int result = a + b + c;
        return result;
    }

    int subtract(int a, int b) {
        int result = a - b;
        return result;
    }

    int multiply(int a, int b) {
        int result = a * b;
        return result;
    }
}
