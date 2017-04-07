package com.cjmex.binder;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int MESSAGE_NEW_BOOK_ARRIVED = 1;


    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.button)
    Button button;
    @Bind(R.id.activity_main)
    RelativeLayout activityMain;
    IBookManager proxy;

    /**
     * My
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
    }

    private Messenger mService;

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = new Messenger(service);
            Message message = Message.obtain();
            message.replyTo = messenger;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    Messenger messenger = new Messenger(new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    });


    @Override
    protected void onStart() {
        super.onStart();
        bindService(new Intent(this, BookService.class), serviceConnection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
//        unbindService(serviceConnection);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        if (proxy != null && proxy.asBinder().isBinderAlive()) {
            try {
                proxy.unregisterListener(mOnNewBookArrivedListener);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        unbindService(serviceConnection);

        super.onDestroy();
    }

    private void init() {
    }

    @OnClick(R.id.button)
    public void play() {
        List<Book> list;
        try {
            list = proxy.getBookList();
            if (!list.isEmpty()) {
                textView.append(list.toString());
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            proxy = IBookManager.Stub.asInterface(service);
            Book book = new Book(1, "Android");
            try {
                proxy.addBook(book);

                List<Book> newList = proxy.getBookList();
                Log.d(TAG, "add book:" + newList.toString());

                proxy.registerListener(mOnNewBookArrivedListener);

            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            proxy = null;
        }
    };

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MESSAGE_NEW_BOOK_ARRIVED:
                    Log.d(TAG, "new book :" + (msg.obj).toString());
                    textView.append((msg.obj).toString());
                    break;
            }
        }
    };

    private IOnNewBookArrivedListener mOnNewBookArrivedListener = new IOnNewBookArrivedListener.Stub() {

        @Override
        public void onNewBookArrived(Book newBook) throws RemoteException {
            mHandler.obtainMessage(MESSAGE_NEW_BOOK_ARRIVED, newBook)
                    .sendToTarget();
        }
    };

    private IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() {
        @Override
        public void binderDied() {
            if (proxy == null) {
                return;
            }
            proxy.asBinder().unlinkToDeath(mDeathRecipient, 0);
            proxy = null;
            // 重新绑定
            bindService(new Intent(MainActivity.this, BookService.class), serviceConnection, BIND_AUTO_CREATE);
        }
    };

}
