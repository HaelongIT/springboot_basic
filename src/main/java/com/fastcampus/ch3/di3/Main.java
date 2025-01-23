package com.fastcampus.ch3.di3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // AC를 생성(non-Web AC 중에서 자바 설정파일을 사용하는 경우)
        // AC의 설정 파일은 AppConfig.class(자바설정)
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        // 실습1 : AC에서 특정 객체 가져오기
        // Car car = (Car) ac.getBean("car");      // by Name으로 객체 AC 저장소에서 꺼내오기
        Car car = ac.getBean("car", Car.class);
        System.out.println("car = " + car);

        // 실습2 : AC에서 특정 객체 가져오기(객체[Bean]가 프로토타입인 경우)
        System.out.println();
        System.out.println("실습2 시작");
        Engine engine = ac.getBean(Engine.class);
        Engine engine2 = ac.getBean(Engine.class);
        Engine engine3 = ac.getBean(Engine.class);

        System.out.println("car = " + car);
        System.out.println("engine = " + engine);
        System.out.println("engine2 = " + engine2);
        System.out.println("engine3 = " + engine3);

        // 실습3 : AC의 여러 메서드들 사용해보기
        System.out.println();
        System.out.println("실습3 시작");

        System.out.println("ac.getBeanDefinitionCount() = " + ac.getBeanDefinitionCount());
        System.out.println("ac.getBeanDefinitionNames() = " + Arrays.toString(ac.getBeanDefinitionNames()));
        System.out.println("ac.containsBeanDefinition(\"engine\") = " + ac.containsBeanDefinition("engine"));
        System.out.println("ac.isSingleton(\"Car\") = " + ac.isSingleton("car"));
        System.out.println("ac.isPrototype(\"engine\") = " + ac.isPrototype("engine"));
    }
}
