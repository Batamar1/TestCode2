package com.melnikov.distribution;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@EnableRabbit
@Service
public class RabbitMqListener {
    Logger logger = Logger.getLogger(RabbitMqListener.class);

    @RabbitListener(queues = "queue1")
    public void processQueue1(EmailDTO message){
        logger.info("Email has sent, email = " + message.toString());
    }
}
