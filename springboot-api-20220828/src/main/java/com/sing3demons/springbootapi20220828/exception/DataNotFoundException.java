package com.sing3demons.springbootapi20220828.exception;

import com.sing3demons.springbootapi20220828.model.MessageInfo;
import lombok.Data;

@Data
public class DataNotFoundException extends RuntimeException {
    private MessageInfo messageInfo;

    public DataNotFoundException(MessageInfo messageInfo) {
        this.messageInfo = messageInfo;
    }
}
