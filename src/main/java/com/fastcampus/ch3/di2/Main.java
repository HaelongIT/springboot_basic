package com.fastcampus.ch3.di2;

public class Main {
    public static void main(String[] args) {
        AppContext ac = new AppContext();

        // 1. by Name으로 map에서 데이터 찾기
        Car car = (Car) ac.getBean("car");
        System.out.println("car = " + car);

        // 2. by Type으로 map에서 데이터 찾기
        Car car2 = (Car) ac.getBean(Car.class);
        System.out.println("car2 = " + car2);

        // 3. 하드코딩 -> 자바 설정파일로 대체(동적, 변경에 용이한 코드)
        System.out.println();
        System.out.println("3번 예제 시작");

        AppContext ac2 = new AppContext(AppConfig.class);       // AppContext(Class clazz) : 설정파일 자바클래스(클래스 객체)를 지정

        Car car3 = (Car) ac2.getBean("car");
        System.out.println("car3 = " + car3);

        Car car4 = (Car) ac2.getBean(Car.class);
        System.out.println("car4 = " + car4);

        Engine engine = (Engine) ac2.getBean("engine");
        System.out.println("engine = " + engine);

        Door door = (Door) ac2.getBean(Door.class);
        System.out.println("Door = " + door);

        // 4. 객체의 참조변수 필드에 직접 객체 주입
        System.out.println();
        System.out.println("4번 예제 시작");

        // 빈들 끼리의 관계를 설정(수동 설정)
//        car3.setEngine(engine);     // car.engine = engine; 과 동일한 코드(객체의 참조변수인 필드에 객체 주입)
//        car3.setDoor(door);
        System.out.println("car3 = " + car3);
        System.out.println("car4 = " + car4);       // car3와 car4는 같은 객체의 참조값을 사용하기 때문에, 출력 결과도 같음

        // 5. 객체의 참조변수 필드에 자동 객체 주입(by Type)
        System.out.println();
        System.out.println("5번 예제 시작");

        System.out.println("car3 = " + car3);

        // 6. 객체의 참조변수 필드에 자동 객체 주입2(by Name)
        System.out.println();
        System.out.println("6번 예제 시작");

        System.out.println("car3 = " + car3);
    }
}
