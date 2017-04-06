package com.yitouwushui.viewstudy;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.WebView;

/**
 * Created by ding on 2017/4/5.
 */

public class MyWebView extends WebView {

    private ITouch touch;
    private float x1, y1;

    private static final String tag = "myWebView";


    /**
     * webView 滑动位置在底部
     */
    private static final int IN_BOTTOM = 1;
    /**
     * webView 滑动位置在顶部
     */
    private static final int IN_TOP = 2;
    /**
     * webView 滑动位置在中间
     */
    private static final int IN_MIDDLE = 3;
    /**
     * 是否拦截
     */
    private boolean isIntercept = true;

    private int position;

    public MyWebView(Context context) {
        super(context);
    }

    public MyWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }


    /**
     * 取得横向滚动宽度
     */
    public int getHorizontalScrollWidth() {
        return computeHorizontalScrollRange();
    }

    /**
     * 取得纵向滚动高度
     */
    public int getVerticalScrollHeight() {
        return computeVerticalScrollRange();
    }

    public void setITouch(ITouch touch) {
        this.touch = touch;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        float webcontent = getContentHeight() * getScale();// webview的高度
        float webnow = getHeight() + getScrollY();// 当前webview的高度
        Log.i("TAG1", "webview.getScrollY()====>>" + getScrollY());
        if (Math.abs(webcontent - webnow) < 1) {
            // 已经处于底端
            // Log.i("TAG1", "已经处于底端");
            position = IN_BOTTOM;
//            listener.onPageEnd(l, t, oldl, oldt);
        } else if (getScrollY() == 0) {
            // Log.i("TAG1", "已经处于顶端");
            position = IN_TOP;
//            listener.onPageTop(l, t, oldl, oldt);
        } else {
            position = IN_MIDDLE;
//            listener.onScrollChanged(l, t, oldl, oldt);
        }
    }


    public interface OnScrollChangeListener {
        public void onPageEnd(int l, int t, int oldl, int oldt);

        public void onPageTop(int l, int t, int oldl, int oldt);

        public void onScrollChanged(int l, int t, int oldl, int oldt);

    }

    private OnScrollChangeListener listener;

    public void setOnScrollChangeListener(OnScrollChangeListener listener) {

        this.listener = listener;

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        touch.isOnTouch(true);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                y1 = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                x1 = 0;
                y1 = 0;
                break;
            case MotionEvent.ACTION_MOVE:
                float x2 = event.getX();
                float y2 = event.getY();
                int position = this.position;
                switch (position) {
                    case IN_BOTTOM:
                        if (y2 - y1 > 0) {
                            isIntercept = true;
                            Log.d(tag, String.valueOf(1));
                        } else {
                            isIntercept = false;
                            Log.d(tag, String.valueOf(2));
                        }
                        break;
                    case IN_TOP:
                        if (y1 - y2 > 0) {
                            isIntercept = true;
                            Log.d(tag, String.valueOf(3));
                        } else {
                            isIntercept = false;
                            Log.d(tag, String.valueOf(4));
                        }
                        break;
                    case IN_MIDDLE:
                        isIntercept = true;
                        Log.d(tag, String.valueOf(5));
                        break;
                }
                Log.d(tag, String.valueOf(isIntercept));
                touch.isOnTouch(isIntercept);
//                    if (x2 == x1 || Math.abs(y2 - y1) > Math.abs(x2 - x1)) { //竖直方向移动
//                        if (touch != null) {
//                            touch.isOnTouch(isIntercept);
//                        }
//                    } else {
//                        if (touch != null) {
//                            touch.isOnTouch(isIntercept);
//                        }
//                    }
                break;
        }

        return super.onTouchEvent(event);
    }

    public interface ITouch {
        void isOnTouch(boolean b);

        void onTouchPointerMult(boolean b);
    }

}
