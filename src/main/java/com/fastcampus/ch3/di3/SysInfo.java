package com.fastcampus.ch3.di3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("setting.properties")
public class SysInfo {

    // 외부 설정파일(setting.properties)에서 읽어오는 경우
    @Value("${autosaveDir}")
    String autosaveDir;

    @Value("${autosaveInterval}")
    int autoInterval;

    @Value("${autosave}")
    boolean autosave;

    // 시스템 환경변수에서 읽어오는 경우
    @Value("#{systemProperties['user.timezone']}")
    String timezone;

    @Value("#{systemEnvironment['PWD']}")
    String currDir;

    @Value("#{systemEnvironment['USER']}")
    String user;

    @Override
    public String toString() {
        return "SysInfo{" +
                "autosaveDir='" + autosaveDir + '\'' +
                ", autoInterval=" + autoInterval +
                ", autosave=" + autosave +
                ", timezone='" + timezone + '\'' +
                ", currDir='" + currDir + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
