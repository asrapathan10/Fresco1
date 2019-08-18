package com.nirvanaapp.sourcekode.fresco;

import retrofit2.Call;
import retrofit2.http.GET;
public interface ApiService{
    public static final String key="13212868-aa2809cf645025656cdea57a3";
    @GET("?key" + key)
    Call<Root> getInfo();
}

