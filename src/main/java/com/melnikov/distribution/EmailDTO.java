package com.melnikov.distribution;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmailDTO implements Serializable{
    String[] receivers;
    String subject;
    String text;
}


