package com.yitouwushui.viewstudy;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SaveInstanceActivity extends Activity {

    private static final String TAG = "SaveInstanceActivity";
    @Bind(R.id.button1)
    Button button1;
    @Bind(R.id.editText1)
    EditText editText1;
    @Bind(R.id.textView3)
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_instance);
        ButterKnife.bind(this);
        editText1.setText("这是editText");
        textView3.setText("这是textView3");
        if (savedInstanceState != null) {
            String test = savedInstanceState.getString("extra_test");
            Log.d(TAG, "[onCreate]restore extra_test:" + test);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent, time=" + intent.getLongExtra("time", 0));
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume");
        super.onStart();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged, newOrientation:" + newConfig.orientation);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
        outState.putString("extra_test", "保存的数据");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //Log.d(TAG, "onRestoreInstanceState");
        String test = savedInstanceState.getString("extra_test");
        Log.d(TAG, "[onRestoreInstanceState]restore extra_test:" + test);
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }

    @OnClick({R.id.button1, R.id.editText1, R.id.textView3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Intent intent = new Intent("com.yitouwushui.viewstudy.ScrollWebViewActivity");
                //intent.setClass(MainActivity.this, SecondActivity.class);
                intent.putExtra("time", System.currentTimeMillis());
                intent.addCategory("com.yitouwushui.viewstudy.ScrollWebViewActivity");
                intent.setDataAndType(Uri.parse("file://abc"), "text/plain");
                startActivity(intent);
                break;
            case R.id.editText1:
                break;
            case R.id.textView3:
                break;
        }
    }
}
