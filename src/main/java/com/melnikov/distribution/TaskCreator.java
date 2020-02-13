package com.melnikov.distribution;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component()
@Scope("prototype")
public class TaskCreator implements Runnable {

    Logger logger = Logger.getLogger(TaskCreator.class);

    @Autowired
    RabbitMqProducer rabbitMqProducer;

    @Override
    public void run(){
        try {
            long randomNumber;
            while (true) {
                randomNumber =  (long) (Math.random()*5 + 5)*1000;
                logger.info("RandomTaskDelay = " + randomNumber);
                Thread.sleep(randomNumber);
                rabbitMqProducer.sendMessage();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
