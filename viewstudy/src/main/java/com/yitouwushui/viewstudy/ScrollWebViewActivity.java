package com.yitouwushui.viewstudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yitouwushui.viewstudy.ui.MyScrollView;
import com.yitouwushui.viewstudy.ui.MyWebView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ScrollWebViewActivity extends AppCompatActivity {

    @Bind(R.id.view3)
    MyWebView myWebView;
    @Bind(R.id.view4)
    MyScrollView myScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_web_view);
        ButterKnife.bind(this);

        myWebView.loadData(getString(R.string.web_content), "text/html;charset=UTF-8", null);
        myWebView.setITouch(new MyWebView.ITouch() {
            @Override
            public void isOnTouch(boolean b) {
                myScrollView.requestDisallowInterceptTouchEvent(b);
            }

            @Override
            public void onTouchPointerMult(boolean b) {

            }
        });
    }
}
