package com.yitouwushui.viewstudy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yitouwushui.viewstudy.ui.MyImageView;
import com.yitouwushui.viewstudy.ui.Relati;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String tag = "viewStudy";
    GestureDetector mGestureDetector;
    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.button)
    Button button;
    @Bind(R.id.button2)
    Button button2;
    @Bind(R.id.view)
    MyImageView view;
    @Bind(R.id.view2)
    Relati view2;
    @Bind(R.id.scroll)
    Button scroll;
    @Bind(R.id.demo1)
    Button demo1;
    @Bind(R.id.demo2)
    Button demo2;
    @Bind(R.id.bt_remote)
    Button btRemote;
    @Bind(R.id.textView2)
    TextView textView2;
    @Bind(R.id.activity_main)
    RelativeLayout activityMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mGestureDetector = new GestureDetector(this, onGestureListener);
        mGestureDetector.setIsLongpressEnabled(false);

    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
////        switch (event.getAction()) {
////            case MotionEvent.ACTION_MOVE:
////                VelocityTracker velocityTracker = VelocityTracker.obtain();
////                velocityTracker.addMovement(event);
////                velocityTracker.computeCurrentVelocity(1000);
////                float xVelocity = velocityTracker.getXVelocity();
////                float yVelocity = velocityTracker.getYVelocity();
////                Log.d(tag, "x方向" + xVelocity);
////                Log.d(tag, "y方向" + yVelocity);
////                velocityTracker.clear();
////                velocityTracker.recycle();
////                break;
////        }
//        boolean consume = mGestureDetector.onTouchEvent(event);
//        Log.d(tag, String.valueOf(consume));
//        return consume;
//    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean consume = super.onTouchEvent(event);
        Log.d(tag, "_onTouchEvent:" + String.valueOf(consume));
        return consume;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean consume = super.dispatchTouchEvent(ev);
        Log.d(tag, "dispatchTouchEvent:" + String.valueOf(consume));
        return consume;
    }

    GestureDetector.OnGestureListener onGestureListener = new GestureDetector.OnGestureListener() {
        @Override
        public boolean onDown(MotionEvent e) {
            return false;
        }

        @Override
        public void onShowPress(MotionEvent e) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {

        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return false;
        }
    };

    @OnClick({R.id.textView, R.id.button, R.id.button2, R.id.scroll, R.id.demo1, R.id.demo2, R.id.bt_remote, R.id.textView2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textView:
                break;
            case R.id.button:
                String str = textView.getText().toString() + "\n" + "\\\\";
                textView.setText(str);
                break;
            case R.id.button2:
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.sroll);
                button.startAnimation(animation);
                break;
            case R.id.scroll:
                startActivity(new Intent(MainActivity.this, ScrollWebViewActivity.class));
                break;
            case R.id.demo1:
                startActivity(new Intent(MainActivity.this, DemoActivity_1.class));
                break;
            case R.id.demo2:
                startActivity(new Intent(MainActivity.this, DemoActivity_2.class));
                break;
            case R.id.bt_remote:
                startActivity(new Intent(MainActivity.this, RemoteViewActivity.class));
                break;
            case R.id.textView2:
                break;
        }
    }
}
