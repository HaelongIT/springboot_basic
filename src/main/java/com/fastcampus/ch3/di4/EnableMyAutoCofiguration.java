package com.fastcampus.ch3.di4;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)           // 클래스, 인터페이스, 열거형(enum), 레코드(record)에만 적용 가능
@Retention(RetentionPolicy.RUNTIME)     // 실행 중에도 유지 됨
@Import(MyImportSelector.class)
public @interface EnableMyAutoCofiguration {
    String value() default "";
}
