package com.nirvanaapp.sourcekode.fresco;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {
    public static final String key="13212868-aa2809cf645025656cdea57a3";
    public static final String url="https://pixabay.com/api/";
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);
    }

}
