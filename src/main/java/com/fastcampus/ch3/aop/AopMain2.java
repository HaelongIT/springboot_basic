package com.fastcampus.ch3.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class AopMain2 {
    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(Config.class);

        MyMath mm = ac.getBean("myMath", MyMath.class);

        mm.add(3, 5);       // aop가 적용될 메서드1
        mm.add(1, 2, 3);    // aop가 적용될 메서드2
        System.out.println("mm.multiply(3, 5) = " + mm.multiply(3, 5));     // aop가 적용도지 않는 메서드1

    }
}
