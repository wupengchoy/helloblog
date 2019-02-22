package com.wupengchoy.mystudy.studydemo.timetask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TimeTask {
//    @Scheduled(cron = "0/5 * * * * *")
    public void begainTask()
    {
        System.out.println(LocalDateTime.now());
    }
}
