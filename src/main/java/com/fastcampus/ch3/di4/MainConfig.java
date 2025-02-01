package com.fastcampus.ch3.di4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//@EnableMyAutoCofiguration("test2")
//@EnableMyAutoCofiguration("test")
//@Import(MyImportSelector.class)
@Import({Config1.class, Config2.class})
@Configuration
// 자바 설정파일
public class MainConfig {
    @Bean
    Car car() { return new Car(); }
}
