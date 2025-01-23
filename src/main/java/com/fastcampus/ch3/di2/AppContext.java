package com.fastcampus.ch3.di2;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AppContext {
    Map map = new HashMap();

    public AppContext() {
        map.put("car", new SportsCar());
        map.put("engine", new Engine());
        map.put("door", new Door());
    }

    public AppContext(Class clazz) {
        Object appConfig = null;
        try {
            appConfig = clazz.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        Method[] methods = clazz.getDeclaredMethods();

        for(Method m : methods) {
            System.out.println("m = " + m.getName());
            for(Annotation anno : m.getDeclaredAnnotations()) {
                if(anno.annotationType() == Bean.class)
                    try {
                        map.put(m.getName(), m.invoke(appConfig, null));    // map.put("car", cofig.car()); 을 동적으로 자바 설정 파일에서 받아오는 코드
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
            }
        }
        doAutowired();      // @Autowired를 찾아서 빈(객체) 간의 자동 연결처리(by Type)
        doResource();       // @Resource를 찾아서 빈(객체) 간의 자동 연결처리(by Name)
    }

    private void doResource() {
        for(Object bean : map.values()) {
            for(Field field : bean.getClass().getDeclaredFields()) {
                if(isReource(field))
                    try {
                        field.set(bean, getBean(field.getName()));      // car.engine = obj;
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
            }
        }
    }

    private boolean isReource(Field field) {
        if(field.getAnnotation(Resource.class) != null)
            return true;
        return false;
    }

    private void doAutowired() {
        for(Object bean : map.values()) {
            for(Field field : bean.getClass().getDeclaredFields()) {
                if(isAutowired(field))
                    try {
                        field.set(bean, getBean(field.getType()));      // car.engine = obj;
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
            }
        }
    }

    private boolean isAutowired(Field field) {
        if(field.getAnnotation(Autowired.class) != null)
            return true;
        return false;
    }

    public Object getBean(String id) {
        return map.get(id);
    }

    public Object getBean(Class clazz) {
        for(Object obj : map.values()) {
            if(clazz.isInstance(obj))
                return obj;
        }
        return null;
    }
}
