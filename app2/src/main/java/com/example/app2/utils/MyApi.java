package com.example.app2.utils;

import com.example.app2.bean.MyBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyApi {
    //http://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/1
    String URL ="http://gank.io/api/data/%E7%A6%8F%E5%88%A9/";
    @GET("20/1")
    Observable<MyBean> myCall();
}
