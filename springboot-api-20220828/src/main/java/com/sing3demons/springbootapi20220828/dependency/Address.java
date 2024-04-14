package com.sing3demons.springbootapi20220828.dependency;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Address {
    private String addressNO = "344";
    private String addressName = "bangkok";
}
