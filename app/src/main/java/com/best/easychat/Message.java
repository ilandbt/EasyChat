package com.best.easychat;

/**
 * Created by EthosIlan on 2/16/15.
 */
public class Message extends Bubble{

    private String text;
    private String id;

    public Message(String text, boolean isIncoming){
        super(isIncoming? BubbleType.textIn: BubbleType.textOut);
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
