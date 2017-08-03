package com.yitouwushui.viewstudy.ui;

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

    private static final String tag = "RelativeLayout";

    public Relati(Context context) {
        super(context);
    }

    public Relati(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(tag, "_onTouchEvent:" +  event.getAction() + "--" + "开始");

        boolean consume = super.onTouchEvent(event);
        Log.d(tag, "_onTouchEvent:" + event.getAction() + "--"  + String.valueOf(consume));
        return consume;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(tag, "onInterceptTouchEvent:" + ev.getAction() + "--"  + "开始");

        boolean consume = super.onInterceptTouchEvent(ev);
        Log.d(tag, "onInterceptTouchEvent:" + ev.getAction() + "--"  + String.valueOf(consume));
        return consume;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(tag, "dispatchTouchEvent:" + ev.getAction() + "--"  + "开始");

        boolean consume = super.dispatchTouchEvent(ev);
        Log.d(tag, "dispatchTouchEvent:" + ev.getAction() + "--" + String.valueOf(consume));
        return consume;
    }

}
