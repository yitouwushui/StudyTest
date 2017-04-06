package com.yitouwushui.viewstudy;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by ding on 2017/3/30.
 */

public class Relati extends RelativeLayout {

    private static final String tag = "line";

    public Relati(Context context) {
        super(context);
    }

    public Relati(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean consume = super.onTouchEvent(event);
        Log.d(tag, "_onTouchEvent:" + String.valueOf(consume));
        return consume;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean consume = super.onInterceptTouchEvent(ev);
        Log.d(tag, "onInterceptTouchEvent:" + String.valueOf(consume));
        return consume;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean consume = super.dispatchTouchEvent(ev);
        Log.d(tag, "dispatchTouchEvent:" + String.valueOf(consume));
        return consume;
    }

}
