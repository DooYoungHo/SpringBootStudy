package com.youngho.core_day1.bean;

import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentProcessorBean {

    public void processPayment() {
        System.out.println("processPayment");
    }
}
