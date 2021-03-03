package com.zzs.service;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author mountain
 * @since 2021/3/3 21:10
 */
@Slf4j
@RabbitListener(queues = "fanout_sms_queue")
@Component
public class SmsConsumerService {

    @RabbitHandler
    private void process(JSONObject msgEntity) {
        try {
            log.info("SmsMsg：==============================" + msgEntity.toJSONString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
