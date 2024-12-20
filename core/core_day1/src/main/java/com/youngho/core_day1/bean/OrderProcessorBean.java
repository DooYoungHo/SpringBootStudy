package com.youngho.core_day1.bean;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderProcessorBean {

    private final OrderReceiverBean orderReceiverBean;
    private final PaymentProcessorBean paymentProcessorBean;

    public void processOrder() {
        orderReceiverBean.receiveOrder();
        paymentProcessorBean.processPayment();
    }
}
