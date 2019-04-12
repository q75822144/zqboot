package com.zqboot.common.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhouquan on 2019/4/12.
 */
@Component
public class KafkaConsumer {

    /**
     * 监听主题,有消息就读取
     * @param message 数据包
     */
    @KafkaListener(topics = {"zhou"})
    public void receiveMessage(String message){
        System.out.println("收到消息"+message);
        // 后续操作待完善
    }
}
