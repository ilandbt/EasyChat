package com.best.easychat;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by EthosIlan on 2/16/15.
 */
public class ChatListView extends ListView {

    public ChatListView (Context context) {
        super(context);
    }

    public ChatListView (Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ChatListView (Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onSizeChanged(int xNew, int yNew, int xOld, int yOld) {
        super.onSizeChanged(xNew, yNew, xOld, yOld);

        setSelection(getCount());

    }
}
