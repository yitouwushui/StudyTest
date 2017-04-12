package com.yitouwushui.studytest;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by ding on 2017/4/12.
 */

public interface MovieService {
    @GET("top250")
    Call<MovieEntity> getTopMovie(@Query("start") int start, @Query("count") int count);

    @Multipart
    @POST("register")
    Call<User> registerUser(@Part("photos") MultipartBody.Part phone, @Part("username") RequestBody username, @Part("password") RequestBody password);
}
