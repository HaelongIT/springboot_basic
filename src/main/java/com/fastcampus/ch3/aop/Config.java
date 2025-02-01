package com.fastcampus.ch3.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy     // AOP 자동 설정
@ComponentScan
@Configuration
public class Config {
}
