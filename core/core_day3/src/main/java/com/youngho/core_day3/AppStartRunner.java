package com.youngho.core_day3;

import com.youngho.core_day3.bean.OrderProcessorBean;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppStartRunner implements ApplicationRunner {

    private final OrderProcessorBean orderProcessorBean;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        orderProcessorBean.processOrder();

    }
}
