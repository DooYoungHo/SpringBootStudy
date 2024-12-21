package com.youngho.core_day2.external;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueTest {

    @Value("${person.name}")
    private String name;

    public void sayName() {
        System.out.println(name);
    }
}
