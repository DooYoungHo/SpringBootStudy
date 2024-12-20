package com.youngho.core_day1.bean;

import org.springframework.stereotype.Component;

@Component
public class OrderReceiverBean {

    public void receiveOrder() {
        System.out.println("receiveOrder");
    }
}
