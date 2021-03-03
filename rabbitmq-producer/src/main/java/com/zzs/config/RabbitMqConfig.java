package com.zzs.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mm013
 * @Date 2021/3/3 16:49
 */
@Configuration
public class RabbitMqConfig {
    /**
     * 定义交换机
     */
    private String EXCHANGE_SPRINGBOOT_NAME = "/mayikt_ex";
    /**
     * 短信队列
     */
    private String FANOUT_SMS_QUEUE = "fanout_sms_queue";
    /**
     * 邮件队列
     */
    private String FANOUT_EMAIL_QUEUE = "fanout_email_queue";

    /**
     * 配置smsQueue
     *
     * @return
     */
    @Bean
    public Queue smsQueue() {
        return new Queue(FANOUT_SMS_QUEUE);
    }
    /**
     * 配置emailQueue
     *
     * @return
     */
    @Bean
    public Queue emailQueue() {
        return new Queue(FANOUT_EMAIL_QUEUE);
    }
    /**
     * 配置fanoutExchange
     *
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(EXCHANGE_SPRINGBOOT_NAME);
    }
    // 绑定交换机 sms
    @Bean
    public Binding bindingSmsFanoutExchange(Queue smsQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(smsQueue).to(fanoutExchange);
    }
    // 绑定交换机 email
    @Bean
    public Binding bindingEmailFanoutExchange(Queue emailQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(emailQueue).to(fanoutExchange);
    }
}

