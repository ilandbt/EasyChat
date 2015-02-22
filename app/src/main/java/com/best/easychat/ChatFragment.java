package com.best.easychat;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class ChatFragment extends android.support.v4.app.Fragment{
//public abstract class ChatFragment extends android.support.v4.app.Fragment {
//    public abstract void init(Bundle savedInstanceState);

    private final String TAG = this.getClass().getSimpleName();

    private ViewGroup rootView;
    private ChatListView chatListView;
    private EditText inputEditText;
    private Button inputSendButton;

    public ChatFragment() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //init views
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_chat, container, false);

        chatListView = (ChatListView) rootView.findViewById(R.id.chatListView);
        inputEditText = (EditText) rootView.findViewById(R.id.inputEditText);
        inputSendButton = (Button) rootView.findViewById(R.id.inputSendButton);

        //set click listener
        inputSendButton.setOnClickListener(inputSendButtonListener);

        //set chat list view adapter
        //TODO: add adapter to chatListView
        ArrayList<Message> list = new ArrayList<>();
        list.add(new Message("", true));
        list.add(new Message("", true));
        list.add(new Message("", true));
        list.add(new Message("", true));
        list.add(new Message("", true));
        list.add(new Message("", true));
        list.add(new Message("", true));
        list.add(new Message("", true));
        list.add(new Message("", true));
        list.add(new Message("", true));
        list.add(new Message("", true));
        list.add(new Message("", true));
        list.add(new Message("", true));


        ChatAdapter adapter = new ChatAdapter(getActivity(), list);
        chatListView.setAdapter(adapter);

        //TODO: add abstruct methos and class
        //init(savedInstanceState)
        return rootView;
    }

    //input send button click listener
    private View.OnClickListener inputSendButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(TAG, "inputSendButtonListener");
        }
    };


}
