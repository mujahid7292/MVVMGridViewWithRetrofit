package com.sand_corporation.www.mvvmgridviewwithretrofit.RestAPI;

import com.sand_corporation.www.mvvmgridviewwithretrofit.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static Retrofit retrofit = null;

    public static OkHttpClient.Builder getOkHttpClient(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(3,TimeUnit.MINUTES)
                .readTimeout(3,TimeUnit.MINUTES)
                .writeTimeout(3,TimeUnit.MINUTES);
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (BuildConfig.DEBUG){
            builder.addInterceptor(interceptor);
        }
        return builder;
    }

    public static Retrofit getRetrofit(String BASE_URL){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient().build())
                .build();
        return retrofit;
    }
}
