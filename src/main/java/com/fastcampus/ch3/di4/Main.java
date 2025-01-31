package com.fastcampus.ch3.di4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

//@SpringBootApplication        // SBP는 아래 3개의 애너테이션을 같이 사용하는 것과 동일함
// @SpringBootConfiguration        // @Confiquration과 동일하다
@Configuration
//@EnableAutoConfiguration
@ComponentScan
public class Main {

    public static void main(String[] args) {
//        ApplicationContext ac = SpringApplication.run(Main.class, args);
//        ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class, Config1.class, Config2.class);   // 자바 설정을 이용하는 AC
        ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);
//        System.out.println("ac = " + ac);

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        Arrays.sort(beanDefinitionNames);       // 빈 목록이 담긴 배열을 정렬
        Arrays.stream(beanDefinitionNames)      // 배열을 스트림으로 변환
                .filter(b->!b.startsWith("org"))    // org로 시작하는 빈의 이름을 제외
                .forEach(System.out::println);  // 스트림 요소를 하나씩 꺼내서 출력

        System.out.println("ac.getBean(\"sportsCar\") = " + ac.getBean("sportsCar"));
    }

//    @Bean
//    MyBean myBean() { return new MyBean(); }
}
