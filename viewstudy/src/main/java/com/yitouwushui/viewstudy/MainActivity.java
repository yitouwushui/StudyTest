package com.yitouwushui.viewstudy;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String tag = "viewStudy";
    GestureDetector mGestureDetector;
    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.button)
    Button button;
    @Bind(R.id.button2)
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mGestureDetector = new GestureDetector(this, onGestureListener);
        mGestureDetector.setIsLongpressEnabled(false);

        button2.setOnClickListener(onClickListener);
        button.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button:
                    String str = textView.getText().toString() + "\n" + "\\\\";
                    textView.setText(str);
                    break;
                case R.id.button2:
                    Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.sroll);
                    button.startAnimation(animation);
                    break;
            }
        }
    };

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
}
