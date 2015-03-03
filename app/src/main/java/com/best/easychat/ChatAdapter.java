package com.best.easychat;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by EthosIlan on 2/16/15.
 */
public class ChatAdapter extends BaseAdapter {

    private final String TAG = getClass().getSimpleName();

    private Context context;
    private ArrayList<Bubble> messageList;

    //
    private boolean hasInComingAvatar = true;
    private boolean hasOutGoingAvatar = true;
    private boolean hasIsTyping = false;
    private boolean hasLoadMore = false;

    //private String senderId;

    public ChatAdapter(Context context){
        this.context = context;
        this.messageList = new ArrayList<>();
        //this.senderId = senderId;
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
        Bubble bubble = (Bubble)getItem(position);

        View row = convertView;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //row = inflater.inflate(R.layout.sender_bubbel, parent, false);

            switch (bubble.getType()) {
                case textIn:
                    row = inflater.inflate(R.layout.sender_bubbel, parent, false);
                    break;
                case textOut:
                    Message message = (Message)bubble;
                    row = inflater.inflate(R.layout.reciver_bubble, parent, false);
                    break;
                case typing:
                    //row = inflater.inflate(R.layout.sender_bubbel, parent, false);
                    break;
                case newMessage:
                    //row = inflater.inflate(R.layout.sender_bubbel, parent, false);
                    break;
                case timeStamp:
                    row = inflater.inflate(R.layout.chat_time_stamp, parent, false);
                    break;
            }

        }

        switch (bubble.getType()) {
            case textIn:
                Message inMessage = (Message)bubble;
                TextView text = (TextView) row.findViewById(R.id.senderText);
                text.setText(inMessage.getText());
                break;
            case textOut:
                Message outMessage = (Message)bubble;
                text = (TextView) row.findViewById(R.id.reciverText);
                text.setText(outMessage.getText());
                break;
            case timeStamp:
                TimeStamp time = (TimeStamp)bubble;
                TextView timeText = (TextView) row.findViewById(R.id.timeStamp);
                timeText.setText(time.getTime());
                break;
            case typing:
                //TODO: handle isT yping
                break;
            case newMessage:
                //TODO: handle new Message
                break;
        }

        return row;
    }

      //////////////////////////////////////
     //   implement all public methods   //
    //////////////////////////////////////

    public void setOutGoingBubble(){

    }

    public void setInComingBubble(){

    }

    public void setHasInComingAvatar(boolean hasAvatar){

    }

    public void setHasOutGoingAvatar(boolean hasAvatar){

    }

//    public void addIsTyping(){
//        this.messageList.add(new IsTyping());
//        notifyDataSetChanged();
//        hasIsTyping = true;
//    }

//    public void removeIsTyping(boolean shouldNotify){
//        int lastBubble = this.messageList.size()-1;
//        if (lastBubble > 0) {
//            Bubble bubble = this.messageList.get(lastBubble);
//
//            if (bubble.getType() == Bubble.BubbleType.typing){
//                this.messageList.remove(lastBubble);
//            }
//
//            if (shouldNotify) {
//                notifyDataSetChanged();
//            }
//        }
//        hasIsTyping = false;
//    }

//    public void addNewMessagesIndicator(){
//        this.messageList.add(new NewMessageIndicator());
//        notifyDataSetChanged();
//    }

//    public void removeNewMessagesIndicator(){
//        Bubble bubble;
//        for (int i = this.messageList.size()-1; i >= 0; i--) {
//            bubble = this.messageList.get(i);
//            if (bubble.getType() == Bubble.BubbleType.newMessage){
//                this.messageList.remove(i);
//                break;
//            }
//        }
//        notifyDataSetChanged();
//    }

    public void addNewMessage(Message message, boolean shouldNotify){
        if (hasIsTyping){
            //removeIsTyping(false);
            this.messageList.add(message);
            //addIsTyping();
        } else {
            this.messageList.add(message);
        }

        if (shouldNotify) {
            notifyDataSetChanged();
        }
    }

    public void addOldMessage(Message message){
        this.messageList.add(0, message);
        notifyDataSetChanged();
    }

    public void addTimeStamp(TimeStamp time){
        this.messageList.add(time);
    }

    @Override
    public int getViewTypeCount() {
        return 6;
    }

    @Override
    public int getItemViewType(int position) {
        return ((Bubble)getItem(position)).getType().getValue();
    }
}
