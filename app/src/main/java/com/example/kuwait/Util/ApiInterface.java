package com.example.kuwait.Util;

import com.example.kuwait.AllNews.NewsModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("filterWebContent")
    Call<NewsModel> getDataFromSearch(@Field("q") String q,@Field("token")String token ,@Field("sort") String sort,@Field("ts") String ts,@Field("language") String language);
}
