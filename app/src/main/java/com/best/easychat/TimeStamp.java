package com.best.easychat;

/**
 * Created by EthosIlan on 3/3/15.
 */
public class TimeStamp extends Bubble{

    private String time;

    public TimeStamp(String time) {
        super(BubbleType.timeStamp);
        this.time = time;
    }

    public String getTime() {
        return time;
    }
}
