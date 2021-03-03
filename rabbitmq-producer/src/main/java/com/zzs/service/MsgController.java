package com.zzs.service;

import com.alibaba.fastjson.JSONObject;
import com.zzs.MsgEntity;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author mm013
 * @Date 2021/3/3 16:54
 */
@RestController
public class MsgController {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("/sendMsg")
    public String sennMsg(){
        MsgEntity msgEntity = new MsgEntity(UUID.randomUUID().toString(),"1","1343133313","asdasda@qq.com");
        amqpTemplate.convertAndSend("/mayikt_ex","",JSONObject.toJSONString(msgEntity));
        return "success";
    }
}
