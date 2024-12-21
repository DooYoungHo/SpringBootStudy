package com.youngho.core_day2;

import com.youngho.core_day2.external.ConfigurePropertiesTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ConfigurePropertiesTest.class)
public class CoreDay2Application {

    public static void main(String[] args) {
        SpringApplication.run(CoreDay2Application.class, args);
    }

}
