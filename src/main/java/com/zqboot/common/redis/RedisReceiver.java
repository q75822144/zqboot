package com.zqboot.common.redis;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * redis消息队列生产者
 * Created by zhouquan on 2018/5/15.
 */
public class RedisReceiver {

    private CountDownLatch latch;

    @Autowired
    public RedisReceiver(CountDownLatch latch) {
        this.latch = latch;
    }

    public void receiveMessage(Object message) {
        System.out.println("Received <" + message.toString() + ">");
        latch.countDown();
    }
}
