package com.best.easychat;

/**
 * Created by EthosIlan on 2/22/15.
 */
public class Bubble {

    public enum BubbleType {
        //text, typing, newMessage
        text(0), typing(1), newMessage(2);

        private final int value;

        private BubbleType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private BubbleType type;

    public Bubble(BubbleType type) {
        this.type = type;
    }

    public BubbleType getType(){
        return this.type;
    }
}
