package com.fastcampus.ch3.di2;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

public class Car {

    @Autowired      // by Type으로 자동검색해서 객체 주입
    Engine engine;

    @Resource       // @Resource(name="door") 가 기본값이라 name 설정 생략해도 됨
    Door door;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", door=" + door +
                '}';
    }
}
