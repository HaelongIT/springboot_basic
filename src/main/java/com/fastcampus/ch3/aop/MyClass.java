package com.fastcampus.ch3.aop;

import org.springframework.transaction.annotation.Transactional;

public class MyClass {
    @Transactional
    void aaa() {
        System.out.println("aaa() is called");
    }

    void aaa2() {
        System.out.println("aaa2() is called");
    }

    void bbb() {
        System.out.println("bbb() is called");
    }
}
