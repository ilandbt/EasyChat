package com.best.easychat;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;


public class ChatFragment extends android.support.v4.app.Fragment{
//public abstract class ChatFragment extends android.support.v4.app.Fragment {
//    public abstract void init(Bundle savedInstanceState);

    private final String TAG = this.getClass().getSimpleName();

    private ViewGroup rootView;
    private ChatListView chatListView;
    private EditText inputEditText;
    private ImageButton inputSendButton;

    public ChatFragment() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //init views
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_chat, container, false);

        chatListView = (ChatListView) rootView.findViewById(R.id.chatListView);
        inputEditText = (EditText) rootView.findViewById(R.id.inputEditText);
        inputEditText.addTextChangedListener(imputTextWatch);

        inputSendButton = (ImageButton) rootView.findViewById(R.id.inputSendButton);

        //set click listener
        inputSendButton.setOnClickListener(inputSendButtonListener);

        //set chat list view adapter
        ChatAdapter adapter = new ChatAdapter(getActivity());
        chatListView.setAdapter(adapter);
        chatListView.addLoadMore();
        chatListView.setOnLoadMoreClickListener(new ChatListView.OnLoadMoreClickListener() {
            @Override
            public void OnClick(View view) {
                Toast.makeText(getActivity(), "load more clicked", Toast.LENGTH_SHORT).show();
                chatListView.startProgress();
            }
        });

        adapter.addNewMessage(new Message("ou1", true), false);
        adapter.addNewMessage(new Message("ou2", true), false);
        adapter.addNewMessage(new Message("in1", false), false);
        adapter.addNewMessage(new Message("out3", true), false);
        adapter.addNewMessage(new Message("in2", false), false);
        adapter.addNewMessage(new Message("in3", false), false);
        adapter.addTimeStamp(new TimeStamp("Monday 20:33"));
        adapter.addNewMessage(new Message("ou4", true), false);
        adapter.addNewMessage(new Message("ou5", true), false);
        adapter.addNewMessage(new Message("in4", false), false);
        adapter.addNewMessage(new Message("out6", true), false);
        adapter.addTimeStamp(new TimeStamp("Shabat 10:14"));
        adapter.addNewMessage(new Message("in5", false), false);
        adapter.addNewMessage(new Message("in6", false), true);

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

    private TextWatcher imputTextWatch = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


}
