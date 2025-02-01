package com.fastcampus.ch3.di4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@EnableConfigurationProperties({MyProperties.class})
//@SpringBootApplication        // SBP는 아래 3개의 애너테이션을 같이 사용하는 것과 동일함
// @SpringBootConfiguration        // @Confiquration과 동일하다
@Configuration
//@EnableAutoConfiguration
@ComponentScan
public class Main implements CommandLineRunner {

    @Autowired
    MyProperties prop;      // 인스턴스 변수, 자동주입

    @Autowired
    ApplicationContext ac;

    @Override       // 인스턴스 메서드
    public void run(String... args) throws Exception {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        Arrays.sort(beanDefinitionNames);       // 빈 목록이 담긴 배열을 정렬
        Arrays.stream(beanDefinitionNames)      // 배열을 스트림으로 변환
                .filter(b->!b.startsWith("org"))    // org로 시작하는 빈의 이름을 제외
                .forEach(System.out::println);  // 스트림 요소를 하나씩 꺼내서 출력

        System.out.println("prop.getEmail() = " + prop.getEmail());
        System.out.println("prop.getDomain() = " + prop.getDomain());
    }

    public static void main(String[] args) {        // static 메서드
        ApplicationContext ac = SpringApplication.run(Main.class, args);
//        ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class, Config1.class, Config2.class);   // 자바 설정을 이용하는 AC
//        ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);
//        System.out.println("ac = " + ac);

//        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
//
//        Arrays.sort(beanDefinitionNames);       // 빈 목록이 담긴 배열을 정렬
//        Arrays.stream(beanDefinitionNames)      // 배열을 스트림으로 변환
//                .filter(b->!b.startsWith("org"))    // org로 시작하는 빈의 이름을 제외
//                .forEach(System.out::println);  // 스트림 요소를 하나씩 꺼내서 출력

//        System.out.println("ac.getBean(\"sportsCar\") = " + ac.getBean("sportsCar"));

//        MyProperties prop = ac.getBean(MyProperties.class);       // 수동으로 빈 검색해서 주입
//        System.out.println("prop.getDomain() = " + prop.getDomain());
//        System.out.println("prop.getEmail() = " + prop.getEmail());
    }



//    @Bean
//    MyBean myBean() { return new MyBean(); }
}
