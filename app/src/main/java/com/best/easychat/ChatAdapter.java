package com.best.easychat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by EthosIlan on 2/16/15.
 */
public class ChatAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Message> messageList;


    //
    private boolean hasInComingAvatar = true;
    private boolean hasOutGoingAvatar = true;
    private boolean hasIsTyping = false;

    public ChatAdapter(Context context, ArrayList<Message> messageList){
        this.context = context;
        this.messageList = messageList;
    }

    @Override
    public int getCount() {
        return this.messageList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.messageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //cornet message
        Message message = (Message)getItem(position);

        View row = convertView;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.sender_bubbel, parent, false);
        }

        return row;
    }

      //////////////////////////////////////
     //   implement all public methods   //
    //////////////////////////////////////

    public void setOutGoingBubble(){

    }

    public void setinComingBubble(){

    }

    public void setHasInComingAvatar(boolean hasAvatar){

    }

    public void setHasOutGoingAvatar(boolean hasAvatar){

    }

    public void addIsTyping(){

    }

    public void removeIsTyping(){

    }

    public void addNewMessagesIndicator(){

    }

    public void addNewMessage(Message message){

    }

    public void addOldMessage(Message message){

    }
}
