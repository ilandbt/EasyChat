package com.best.easychat;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.pnikosis.materialishprogress.ProgressWheel;

/**
 * Created by EthosIlan on 2/16/15.
 */
public class ChatListView extends ListView {

    private final String TAG = getClass().getSimpleName();

    private boolean hasLoadMore = false;
    private ViewGroup header;
    private OnLoadMoreClickListener mOnLoadMoreClickListener;

    interface OnLoadMoreClickListener{
        void OnClick(View view);

    }

    public ChatListView (Context context) {
        super(context);
        inflateHeader();
    }

    public ChatListView (Context context, AttributeSet attrs) {
        super(context, attrs);
        inflateHeader();
    }

    public ChatListView (Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        inflateHeader();
    }

    private void inflateHeader(){
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        header = (ViewGroup) inflater.inflate(R.layout.load_more_layout, this, false);
        Button loadMoreButton = (Button) header.findViewById(R.id.loadMoreButton);
        loadMoreButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnLoadMoreClickListener != null){
                    mOnLoadMoreClickListener.OnClick(v);
                }
            }
        });
        header.setClickable(true);
    }

    @Override
    protected void onSizeChanged(int xNew, int yNew, int xOld, int yOld) {
        super.onSizeChanged(xNew, yNew, xOld, yOld);

        setSelection(getCount());

    }

    public void addLoadMore(){
        hasLoadMore = true;
        addHeaderView(header);
    }

    public void removeLoadMore(){
        hasLoadMore = false;
        removeHeaderView(header);
    }

    public void setOnLoadMoreClickListener(OnLoadMoreClickListener mOnLoadMoreClickListener){
        if (this.mOnLoadMoreClickListener == null){
            this.mOnLoadMoreClickListener = mOnLoadMoreClickListener;
        }
    }
    public void startProgress() {
        if (hasLoadMore){
            Button loadMoreButton = (Button) header.findViewById(R.id.loadMoreButton);
            loadMoreButton.setVisibility(View.GONE);
            ProgressWheel progress = (ProgressWheel) header.findViewById(R.id.progressIndicator);
            progress.setVisibility(View.VISIBLE);

        }
    }

    public void stopProgress() {
        if (hasLoadMore){
            Button loadMoreButton = (Button) header.findViewById(R.id.loadMoreButton);
            loadMoreButton.setVisibility(View.VISIBLE);
            ProgressWheel progress = (ProgressWheel) header.findViewById(R.id.progressIndicator);
            progress.setVisibility(View.GONE);

        }
    }
}
