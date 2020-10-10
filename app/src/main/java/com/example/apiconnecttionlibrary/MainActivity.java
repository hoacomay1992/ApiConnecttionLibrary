package com.example.apiconnecttionlibrary;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://jsonplaceholder.typicode.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        ApiInterface service = retrofit.create(ApiInterface.class);
//
//        Callback<List<Posts>> callback = new Callback<List<Posts>>() {
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
//                response.body().stream().forEach(n -> System.out.println("hoacomay" + n));
//            }
//
//            @Override
//            public void onFailure(Call<List<Posts>> call, Throwable t) {
//                t.printStackTrace();
//            }
//        };
//
//        service.getPosst().enqueue(callback);
    ApiInterface service=ApiClient.getRetrofit().create(ApiInterface.class);
    Call<List<Posts>> callback=service.getPosst();
    callback.enqueue(new Callback<List<Posts>>() {
        @Override
        public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
            
        }

        @Override
        public void onFailure(Call<List<Posts>> call, Throwable t) {

        }
    });
    }
}