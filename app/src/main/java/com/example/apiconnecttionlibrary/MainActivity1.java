package com.example.apiconnecttionlibrary;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.apiconnecttionlibrary.mainactivity1.ServiceGenerator;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        ApiInterface service = ServiceGenerator.createServiceFull(ApiInterface.class);
        Call<List<Posts>> callback = service.getPosst();
        callback.enqueue(new Callback<List<Posts>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                // response.body().stream().forEach(n -> System.out.println("hoacomay1" + n));
                List<Posts> postsList = response.body();
                for (Posts p : postsList) {
                    Log.d("hoacomay1", p.toString() + "\n");
                }
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {

            }
        });
    }
}