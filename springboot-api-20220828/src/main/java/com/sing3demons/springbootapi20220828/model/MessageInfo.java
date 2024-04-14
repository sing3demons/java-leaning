package com.sing3demons.springbootapi20220828.model;

import lombok.Data;

@Data
public class MessageInfo {
    private String code;
    private String decsriptio;

    public MessageInfo(String code, String decsriptio) {
        this.code = code;
        this.decsriptio = decsriptio;
    }
}
