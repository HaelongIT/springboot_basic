package com.fastcampus.ch3.di1;

class Car {}

class SportsCar extends Car {}

class Truck extends Car {}

public class Main {
    public static void main(String[] args) {
        // 1단계 => 2단계 간단 실습
//        Car car = new Truck()
//        Car car = new SportsCar();

        // 3단계 실습
        Car car = getCar();
    }

    static Car getCar() {
//        return new SportsCar();
        return new Truck();
    }
}