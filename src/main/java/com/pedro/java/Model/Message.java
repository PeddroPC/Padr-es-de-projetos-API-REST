package com.pedro.java.Model;

import org.springframework.stereotype.Component;

@Component
public class Message {

    public String getMessage () {
        return Message;
    }

    public void setMessage (String message) {
        Message = message;
    }

    private String Message;
}
