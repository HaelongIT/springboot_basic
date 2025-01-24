package com.fastcampus.ch3.di3;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Car {
//    @Autowired
//    @Resource(name="superEngine")
//    @Inject       // @Autowired와 거의 같음. (치이점 : required 옵션이 없음)
    @Autowired
    @Qualifier("superEngine")
    Engine engine;

//    @Autowired
    @Resource
    Door door;

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", door=" + door +
                '}';
    }

    //    public Car() {}
//
//    @Autowired        // 생성자가 있으면 따로 @Autowired가 없어도 알아서 생성자 주입으로 해줌, 생성자가 여러개인 경우에는 생략하면 안됨
//    public Car(Engine[] engine, Door door) {
//        this.engine = engine;
//        this.door = door;
//    }
}
