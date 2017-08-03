package com.yitouwushui.studytest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {

    @Bind(R.id.bt_get)
    Button btGet;
    @Bind(R.id.bt_post)
    Button btPost;
    @Bind(R.id.tv_content)
    TextView tvContent;
    @Bind(R.id.activity_retrofit)
    RelativeLayout activityRetrofit;
    MovieService movieService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);

        init();

//        uploadFile();

    }

    private void uploadFile() {
        File file = new File(Environment.getExternalStorageDirectory(),"test.png");
        RequestBody photoRequestBody = RequestBody.create(MediaType.parse("image/png"), file);
        MultipartBody.Part photo = MultipartBody.Part.createFormData("photos", "icon.png", photoRequestBody);

        Call<User> call = movieService.registerUser(photo, RequestBody.create(null, "abc"), RequestBody.create(null, "123"));
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    private void init() {
        String baseUrl = "https://api.douban.com/v2/movie/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        movieService = retrofit.create(MovieService.class);

    }

    @OnClick({R.id.bt_get, R.id.bt_post})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_get:
                Call<MovieEntity> call = movieService.getTopMovie(0, 2);
                call.enqueue(new Callback<MovieEntity>() {
                    @Override
                    public void onResponse(Call<MovieEntity> call, Response<MovieEntity> response) {
                        tvContent.setText(response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<MovieEntity> call, Throwable t) {
                        tvContent.setText(t.getMessage());
                    }
                });
                break;
            case R.id.bt_post:
                break;
        }
    }
}
