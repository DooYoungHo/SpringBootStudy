package com.youngho.core_day3.bean;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderProcessorBean {

    private final OrderReceiveBean orderReceiveBean;
    private final PaymentProcessorBean paymentProcessorBean;

    public void processOrder() {
        orderReceiveBean.receiveOrder();
        paymentProcessorBean.processPayment();
    }
}
