package com.best.easychat;

/**
 * Created by EthosIlan on 2/16/15.
 */
public class Message extends Bubble{

    private String text;
    private String id;

    public Message(String text, String id){
        super(BubbleType.text);
        this.text = text;
        this.id = id;
    }

    public String getText(){
        return this.text;
    }

    public String getId(){
        return this.id;
    }
}
