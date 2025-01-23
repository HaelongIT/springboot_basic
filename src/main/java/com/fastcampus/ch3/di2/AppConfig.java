package com.fastcampus.ch3.di2;

import org.springframework.context.annotation.Bean;

public class AppConfig {
    @Bean
    public Car car() {      // 메서드 이름이 빈(AC에서 관리하는 객체)의 이름
        // map.put("car", new Car()); 를 대체하는 동적인 내용(AppContext에서)
        Car car = new Car();
        return car;
    }

    @Bean
    public Engine engine() { return new Engine(); }

    @Bean
    public Door door() { return new Door(); }
}
