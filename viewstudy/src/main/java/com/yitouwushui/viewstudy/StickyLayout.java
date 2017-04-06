package com.yitouwushui.viewstudy;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by ding on 2017/4/6.
 */

public class StickyLayout extends LinearLayout {

    private int mTouchSlop;

    private int mLastX = 0;

    private int mLastY = 0;
    // 分别记录上次滑动的坐标(onInterceptTouEvent)
    private int mLastXInercept = 0;
    private int mLastYInercept = 0;

    public StickyLayout(Context context) {
        super(context);
    }

    public StickyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        return super.onInterceptTouchEvent(ev);
    }
}
