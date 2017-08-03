package com.yitouwushui.viewstudy.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import com.nineoldandroids.view.ViewHelper;

/**
 * Created by ding on 2017/3/30.
 */
public class MyImageView extends android.support.v7.widget.AppCompatImageView {

    private static final String TAG = "MyImageView";
    private int mLastX;
    private int mLastY;


    public MyImageView(Context context) {
        super(context);
    }

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        Log.d(TAG,"onTouchEvent:---" + event.getAction());
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "onTouchEvent down");
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = x - mLastX;
                int deltaY = y - mLastY;
                Log.d(TAG, "move, deltaX:" + deltaX + "deltaY:" + deltaY);
                int translationX = (int) (ViewHelper.getTranslationX(this) + deltaX);
                int translationY = (int) (ViewHelper.getTranslationY(this) + deltaY);
                ViewHelper.setTranslationX(this, translationX);
                ViewHelper.setTranslationY(this, translationY);
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "onTouchEvent up");
                break;
        }
        mLastY = y;
        mLastX = x;
        return true;
    }

}
