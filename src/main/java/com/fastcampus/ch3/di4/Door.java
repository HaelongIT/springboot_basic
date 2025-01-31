package com.fastcampus.ch3.di4;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(OSCondition.class)
public class Door {
    public String toString() {
        return "Door{}";
    }
}
