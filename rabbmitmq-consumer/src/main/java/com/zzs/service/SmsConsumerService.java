package com.zzs.service;

import com.alibaba.fastjson.JSONObject;
import com.zzs.MsgEntity;
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
    private void process(String msg) {
        MsgEntity msgEntity = JSONObject.parseObject(msg).toJavaObject(MsgEntity.class);
        log.info("SmsMsg：==============================" + JSONObject.parseObject(msg));

    }
}
