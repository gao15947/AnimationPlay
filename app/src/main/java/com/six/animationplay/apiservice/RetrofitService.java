package com.six.animationplay.apiservice;

import com.six.animationplay.utils.OkHttpUtils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/3/31.
 */

public class RetrofitService {
    private static final String BASE_URL = "http://api.bilibili.com/";
    private static final String BASE_LIVE_URL = "http://live.bilibili.com/";
    private static Retrofit mRetrofit;
    private static Retrofit mBiliRetrofit;
    private static OkHttpClient mOkHttpClient;

    protected static Retrofit getRetrofit() {
        if (mRetrofit == null) {
            synchronized (RetrofitService.class) {
                if (mRetrofit == null) {
                    if (mOkHttpClient == null) {
                        mOkHttpClient = OkHttpUtils.getOkHttpClient();
                    }
                    mRetrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .client(mOkHttpClient)
                            .build();
                }
            }
        }

        return mRetrofit;
    }


    protected static Retrofit getBiliRetrofit() {
        if (mBiliRetrofit == null) {
            synchronized (RetrofitService.class) {
                if (mBiliRetrofit == null) {
                    if (mOkHttpClient == null) {
                        mOkHttpClient = OkHttpUtils.getOkHttpClient();
                    }
                    mBiliRetrofit = new Retrofit.Builder()
                            .baseUrl(BASE_LIVE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .client(mOkHttpClient)
                            .build();
                }
            }
        }

        return mBiliRetrofit;
    }
}
