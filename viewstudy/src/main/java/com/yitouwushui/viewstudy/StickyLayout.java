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
    private int mLastXIntercept = 0;
    private int mLastYIntercept = 0;
    private boolean mDisallowInterceptTouchEventOnHeader;

    public StickyLayout(Context context) {
        super(context);
    }

    public StickyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int intercepted = 0;
        int x = (int) ev.getX();
        int y = (int) ev.getY();

        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                mLastXIntercept = x;
                mLastYIntercept = y;
                mLastX = x;
                mLastY = y;
                intercepted = 0;
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = x - mLastXIntercept;
                int deltaY = y - mLastYIntercept;
                if (mDisallowInterceptTouchEventOnHeader)
                break;
        }

        return super.onInterceptTouchEvent(ev);
    }
}
