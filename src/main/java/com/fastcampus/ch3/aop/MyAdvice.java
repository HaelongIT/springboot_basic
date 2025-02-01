package com.fastcampus.ch3.aop;

import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyAdvice {
    Pattern p = Pattern.compile("a.*");         // a로 시작하는 문자열

    boolean matches(Method m) { // 지정된 메서드가 패턴에 일치하는지 알려줌
        Matcher matcher = p.matcher(m.getName());
        return  matcher.matches();
    }

    void invoke(Method m, Object obj, Object... args) throws Exception {
        if(m.getAnnotation(Transactional.class) != null)
            System.out.println("[before]{");        // 공통으로 들어갈 코드(메서드 시작 부분)
        m.invoke(obj, args);        // 각각의 메서드를 호출하는 부분 : aaa(), aaa2(), bbb() 호출
        if(m.getAnnotation(Transactional.class) != null)
            System.out.println("}[after]");         // 공통으로 들어갈 코드(메서드 끝 부분)
    }
}
