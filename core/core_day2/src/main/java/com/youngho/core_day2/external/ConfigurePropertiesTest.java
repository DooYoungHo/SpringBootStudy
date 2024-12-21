package com.youngho.core_day2.external;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("person")
public class ConfigurePropertiesTest {

    private String name;

}
