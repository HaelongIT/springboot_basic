package com.fastcampus.ch3.aop;

import java.lang.reflect.Method;

public class AopMain {
    public static void main(String[] args) throws Exception {
        Class myClass = Class.forName("com.fastcampus.ch3.aop.MyClass");
        Object o = myClass.newInstance();

        MyAdvice myAdvice = new MyAdvice();

        for(Method m: myClass.getDeclaredMethods()) {
            myAdvice.invoke(m, o, null);
        }
    }
}
