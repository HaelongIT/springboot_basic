package com.fastcampus.ch3.di4;

import org.springframework.context.annotation.Bean;

public class Config1 {
    @Bean
    Car sportsCar() { return new SportsCar(); }
}
