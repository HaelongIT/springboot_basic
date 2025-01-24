package com.fastcampus.ch3.di3;

import org.springframework.stereotype.Component;

// @Component("superEngine")        // 빈이 저잘될 때, key를 직접 설정해줄 수도 있음
@Component      // 번의 key를 설정하지 않으면,클래스의 첫 글자만 소문자로 바꿔서 key로 설정함
public class SuperEngine extends Engine {
}
