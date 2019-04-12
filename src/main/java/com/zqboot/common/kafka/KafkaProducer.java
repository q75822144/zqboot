package com.zqboot.common.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;

/**
 * Created by zhouquan on 2019/4/12.
 */

@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

//    private static Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    /**
     * 发送消息到Kafka
     * @param channel Topic
     * @param message 数据包
     */
    public void sendChannelMess(String channel, String message){
        ListenableFuture future = kafkaTemplate.send(channel, message);
        future.addCallback(new SuccessCallback() {
            @Override
            public void onSuccess(Object o) {
                System.out.println("发送成功");
            }
        }, new FailureCallback() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("发送失败");
            }
        });
    }

//    @Scheduled(cron = "0/5 * * * * ?")
//    public void task() {
//        String message = new Date().toString();
//        sendChannelMess("match", message);
//    }
}
