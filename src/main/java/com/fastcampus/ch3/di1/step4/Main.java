package com.fastcampus.ch3.di1.step4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

class Car {}

class SportsCar extends Car {}

class Truck extends Car {}

class Engine {}

class Door {}

public class Main {
    public static void main(String[] args) throws Exception {
        // 3단계 실습
//        Car car = getCar();

        // 4단계 실습
        Car car = (Car) getObject("car");
        Engine engine = (Engine) getObject("engine");

        System.out.println("car = " + car);
        System.out.println("engine = " + engine);
    }

    // 3단계의 메서드
    static Car getCar() {
//        return new SportsCar();
        return new Truck();
    }

    // 4단계의 메서드
    static Object getObject(String key) throws Exception {
        // config.txt 를 Properties 객체에 저장
        Properties prop = new Properties();
        Class clazz = null;     // 해당 객체에 지정된 클래스 이름에 해당하는 클래스 설계도를 얻는다
        prop.load(new FileReader("config.txt"));

        // 클래스 설계도 얻기
        String className = prop.getProperty(key);
        clazz = Class.forName(className);

        // 클래스 설계도에 맞는 객체 생성해서 반환
        return clazz.newInstance();
    }
}
