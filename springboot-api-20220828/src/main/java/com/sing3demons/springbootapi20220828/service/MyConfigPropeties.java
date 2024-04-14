package com.sing3demons.springbootapi20220828.service;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "my")
@Data
public class MyConfigPropeties {
    private String message;
}
