package com.yitouwushui.binderpool;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "main";
    ISecurityCenter mSecurityCenter;
    ICompute mCompute;
//    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
            }
        }).start();
    }

    private void doWork() {
        BinderPool binderPool = BinderPool.getInstance(MainActivity.this);
        try {
            IBinder securityBinder = binderPool.queryBinder(BinderPool.BINDER_SECURITY_CENTER);
            mSecurityCenter = SecurityCenterImpl.asInterface(securityBinder);
            Log.d(TAG, "visit ISecurityCenter ");
            String msg = "helloworld-安卓";
            Log.d(TAG, "content:" + msg);
            String password = mSecurityCenter.encrypt(msg);
            Log.d(TAG, "encrypt:" + password);
            Log.d(TAG, "decrypt:" + mSecurityCenter.decrypt(password));
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        Log.d(TAG, "visit ICompute");
        try {
            IBinder computeBinder = binderPool.queryBinder(BinderPool.BINDER_COMPUTE);
            mCompute = ComputeImpl.asInterface(computeBinder);
            Log.d(TAG + 2, "3+5=" + mCompute.add(3, 5));
        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }
}
