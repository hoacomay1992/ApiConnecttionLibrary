package com.example.apiconnecttionlibrary;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/posts")
    Call<List<Posts>> getPosst();
}
