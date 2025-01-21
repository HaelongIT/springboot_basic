package com.fastcampus.ch3.di1;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        Class carClass = car.getClass();    // 1. 객체로부터 Class 객체(설계도) 얻기
        carClass = Car.class;     // 2. 객체 리터럴로부터 Class 객체 얻기
        carClass = Class.forName("com.fastcampus.ch3.di1.Car");

        // 1. 설계도 객체로부터 객체 생성하기
        Car car2 = (Car) carClass.newInstance();
        System.out.println("car2 = " + car2);

        // 2. 클래스에 선언된 멤버변수(필드)와 method 목록 얻기
        Field[] mvArr = carClass.getDeclaredFields();
        Method[] methodArr = carClass.getDeclaredMethods();
//        Method[] methodArr = carClass.getMethods();

        for(Field mv : mvArr) System.out.println("필드 : " + mv.getName());
        for(Method method : methodArr) System.out.println("메서드 : " + method.getName());

        // 3. 메서드 동적으로 호출하기
        // 3-1. 메서드의 정보 얻기
        Method method = carClass.getMethod("setEngine", Engine.class);

        // 3-2. 동적으로 호출하기
        method.invoke(car, new Engine());       // car.setEngine(new Engine());
        System.out.println("car = " + car);     // engine 필드가 채워짐을 확인 가능(setEngine())

        // 4. mv에 set 붙여서 setter 호출하기
        System.out.println();
        System.out.println("!!4번 실습 시작!!");

        for(Field mv : mvArr) {
            System.out.println("mv = " + mv);
            String methodName = "set" + StringUtils.capitalize(mv.getName());   // "set" + "Engine" = "setEngine"
            System.out.println("methodName = " + methodName);

            method = carClass.getMethod(methodName, mv.getType());       // calClass.getMethod("setEngine", Engine.class)
            method.invoke(car, mv.getType().newInstance());     // car.setEngine(new Engine())
        }

        System.out.println("car = " + car);     // 3-2와 다르게, engine 객체가 바뀌고 door 필드가 null이 아님(이유 : 반복문에서 setEngine(), setDoor()이 실행됨)

        // 5. mv에 @Autowired 붙었는지 확인하기
        System.out.println();
        System.out.println("!!5번 실습 시작!!");

        for (Field mv : mvArr) {
            Annotation[] annoArr = mv.getDeclaredAnnotations();
            for (Annotation anno : annoArr) {
                System.out.println("mv.getName() = " + mv.getName());
                System.out.println("anno.annotationType().getSimpleName() = " + anno.annotationType().getSimpleName());
                System.out.println(anno.annotationType() == Autowired.class);
            }
        }

        // 6. @Autowired 붙은 mv에 setter 호출하기(4번 + 5번)
        System.out.println();
        System.out.println("!!6번 실습 시작!!");

        car = new Car();
        System.out.println("전 car = " + car);

        for (Field mv : mvArr) {
            Annotation[] annoArr = mv.getDeclaredAnnotations();
            for (Annotation anno : annoArr) {
                System.out.println("mv.getName() = " + mv.getName());

                if(anno.annotationType() == Autowired.class) {
                    // @Autowired 가 붙은 mv는(조건문) -> setter 호출
                    String methodName = "set" + StringUtils.capitalize(mv.getName());       // "setEngine";
                    method = carClass.getMethod(methodName, mv.getType());      // 메서드 정보 얻어오기
                    method.invoke(car, mv.getType().newInstance());     // car.setEngine(new Engine());
                }
            }
        }
        System.out.println("후 car = " + car);
    }
}
