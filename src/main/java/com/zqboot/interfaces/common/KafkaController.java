package com.zqboot.interfaces.common;

import com.zqboot.common.kafka.KafkaProducer;
import com.zqboot.utils.ResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhouquan on 2019/4/12.
 */
@RestController
public class KafkaController {

    @Autowired
    KafkaProducer kafkaProducer;

    /**
     * 描述：发送消息
     *
     * @param request
     * @param response
     * @author zhouquan
     * @date 2019/4/12 15:12
     */
    @RequestMapping("/sendKafkaMessage")
    public void sendKafkaMessage(HttpServletRequest request, HttpServletResponse response){
        ResultResponse resp = new ResultResponse();
        kafkaProducer.sendChannelMess("zhou","hello world!");
        resp.setResult(true);
        resp.write(response);
    }
}
