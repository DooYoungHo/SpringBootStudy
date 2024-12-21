package com.youngho.core_day2.runner;

import com.youngho.core_day2.external.ConfigurePropertiesTest;
import com.youngho.core_day2.external.ValueTest;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppStartRunner implements ApplicationRunner {

    private final ConfigurePropertiesTest configurePropertiesTest;
    private final ValueTest valueTest;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(configurePropertiesTest.getName());
        valueTest.sayName();
    }
}
