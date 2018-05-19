package com.zqboot.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by zhouquan on 2017/11/24.
 */
@Component
public class SchedulingDemo {

    //每5秒执行一次
    @Scheduled(cron = "0/5 * * * * ?")
    public void task() {
        System.out.println("This is a scheduling.");
    }
}
