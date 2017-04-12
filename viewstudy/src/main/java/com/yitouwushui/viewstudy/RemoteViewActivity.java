package com.yitouwushui.viewstudy;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RemoteViewActivity extends AppCompatActivity {

    @Bind(R.id.bt_notify)
    Button btNotify;
    @Bind(R.id.activity_remote_view)
    RelativeLayout activityRemoteView;
    int i = 1;
    @Bind(R.id.textView_top)
    TextView textViewTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote_view);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.bt_notify)
    public void onClick() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            init();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void init() {
        Intent intent = new Intent(this, RemoteViewActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivities(this, 0,
                new Intent[]{intent}, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setTicker("remote view ")
                .setContentText("这里是内容，这里是内容这里是内容，这里是内容123")
                .setContentTitle("这里是标题")
                .setWhen(System.currentTimeMillis())
                .setDefaults(Notification.DEFAULT_ALL)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .build();
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1, notification);
        textViewTop.setText(String.valueOf(++i));
    }
}
