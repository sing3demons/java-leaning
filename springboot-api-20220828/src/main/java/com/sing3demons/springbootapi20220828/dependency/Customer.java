package com.sing3demons.springbootapi20220828.dependency;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class Customer {
    private String name = "sing";
    Address address;

    public Customer() {

    }

    @Autowired
    public Customer(Address address) {
        this.address = address;
    }
}
