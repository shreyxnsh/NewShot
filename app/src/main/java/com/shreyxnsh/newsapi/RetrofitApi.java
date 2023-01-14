package com.shreyxnsh.newsapi;

import com.shreyxnsh.newsapi.Modals.NewsModal;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RetrofitApi {
    //creating get request
    @GET
    //specifying modal class in call (modal class will store all the data)
    Call<NewsModal> getAllNews(@Url String url);

    @GET
    Call<NewsModal> getNewsByCategory (@Url String url);
}
