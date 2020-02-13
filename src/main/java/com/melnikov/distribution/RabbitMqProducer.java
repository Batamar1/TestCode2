package com.melnikov.distribution;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqProducer {
    Logger logger = Logger.getLogger(RabbitMqProducer.class);

    @Autowired
    AmqpTemplate template;


    //@Scheduled(fixedDelay = 5000)
    public void sendMessage(){
        logger.info("Send message");
        template.convertAndSend("queue1", buildEmail());
    }

    private EmailDTO buildEmail(){
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setReceivers(new String[]{"test1@gmail.com","test2@gmail.com"});
        emailDTO.setSubject("Promo");
        emailDTO.setText("You win");
        return emailDTO;
    }
}
