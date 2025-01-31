package com.fastcampus.ch3.di4;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(TrueCondition.class)
public class Engine {
    public String toString() {
        return "Engine{}";
    }
}
