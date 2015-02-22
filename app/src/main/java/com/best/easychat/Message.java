package com.best.easychat;

/**
 * Created by EthosIlan on 2/16/15.
 */
public class Message {

    public enum MessageType {text, typing}


    private MessageType type;

    private String text;
    private Boolean isMe;

    public Message(String text, Boolean isMe){
        this.text = text;
        this.isMe = isMe;
    }

    public MessageType getType(){
        return this.type;
    }
}
