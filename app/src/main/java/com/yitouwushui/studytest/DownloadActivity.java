package com.yitouwushui.studytest;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.yitouwushui.studytest.download.ProgressDownloader;
import com.yitouwushui.studytest.download.ProgressResponseBody;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;

public class DownloadActivity extends AppCompatActivity implements ProgressResponseBody.ProgressListener {

    public static final String TAG = "MainActivity";
    public static final String PACKAGE_URL = "http://gdown.baidu.com/data/wisegame/df65a597122796a4/weixin_821.apk";

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.bt_pause)
    Button btPause;
    @BindView(R.id.bt_continue)
    Button btContinue;
    @BindView(R.id.bt_download)
    Button btDownload;

    private long breakPoints;
    private ProgressDownloader downloader;
    private File file;
    private long totalBytes;
    private long contentLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.bt_pause, R.id.bt_continue, R.id.bt_download})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_pause:
                downloader.pause();
                Toast.makeText(this, "下载暂停", Toast.LENGTH_SHORT).show();
                // 存储此时的totalBytes，即断点位置。
                breakPoints = totalBytes;
                break;
            case R.id.bt_continue:
                downloader.download(breakPoints);
                break;
            case R.id.bt_download:
                // 新下载前清空断点信息
                breakPoints = 0L;
                file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "sample.apk");
                downloader = new ProgressDownloader(PACKAGE_URL, file, this);
                downloader.download(0L);
                break;
        }
    }

    @Override
    public void onPreExecute(long contentLength) {
        // 文件总长只需记录一次，要注意断点续传后的contentLength只是剩余部分的长度
        if (this.contentLength == 0L) {
            this.contentLength = contentLength;
            progressBar.setMax((int) (contentLength / 1024));
        }
    }

    @Override
    public void update(long totalBytes, boolean done) {
        // 注意加上断点的长度
        this.totalBytes = totalBytes + breakPoints;
        progressBar.setProgress((int) ((totalBytes + breakPoints) / 1024));
        Log.d(TAG, "线程name:" + Thread.currentThread().getName());
        if (done) {
            // 切换回主线程
            Observable.empty()
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnCompleted(new Action0() {
                        @Override
                        public void call() {
                            Toast.makeText(DownloadActivity.this, "下载完成", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .subscribe();

        }
    }
}
