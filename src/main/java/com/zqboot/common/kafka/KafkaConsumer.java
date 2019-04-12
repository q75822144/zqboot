package com.zqboot.common.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhouquan on 2019/4/12.
 */
@Component
public class KafkaConsumer {
    private static Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    /**
     * 监听主题,有消息就读取
     *
     * @param message 数据包
     */
    @KafkaListener(topics = {"zhou"})
    public void receiveMessage(String message) {
        logger.info("11111111");
        System.out.println("收到消息" + message);
        // 后续操作待完善
    }
}
