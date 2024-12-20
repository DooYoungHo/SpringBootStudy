package com.youngho.core_day1;


import com.youngho.core_day1.bean.ChefBean;
import com.youngho.core_day1.bean.DeliveryServiceBean;
import com.youngho.core_day1.bean.OrderProcessorBean;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppStartUpRunner implements ApplicationRunner {

    private final OrderProcessorBean orderReceiverBean;
    private final ChefBean chefBean;
    private final DeliveryServiceBean deliveryServiceBean;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        orderReceiverBean.processOrder();
        chefBean.cook();
        deliveryServiceBean.deliver();
    }
}
