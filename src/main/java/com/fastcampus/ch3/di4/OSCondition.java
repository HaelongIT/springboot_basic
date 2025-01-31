package com.fastcampus.ch3.di4;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class OSCondition implements Condition {
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment env = context.getEnvironment();
//        System.out.println("System.getProperties() = " + System.getProperties());   // 환경변수에서 어떤 값들을 가져올 수 있는지 확인하기
//        return env.getProperty("os.arch").equals("aarch64");
//        return env.getProperty("mode").equals("test");
        return env.getProperty("mode").equals("dev");
    }
}
