package com.my.university.dto;

import io.swagger.annotations.ApiModelProperty;

public class Message {
    @ApiModelProperty(notes = "Response Message",required = true)
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Message() {

    }

    public Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                '}';
    }
}
