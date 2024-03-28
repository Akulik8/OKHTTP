package com.example.okhttp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button getButton;
    Retrofit retrofit;
CountryApi api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "https://restcountries.com/v3.1/";
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(CountryApi.class);

        getButton = findViewById(R.id.getButton);

        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                api.getAllCountry().enqueue(new Callback<List<Country>>() {
                    @Override
                    public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                        Log.d("test", "Success");
                        List<Country> countries = response.body();
                        for (Country country : countries) {
                            Log.d("test", "     - " + country.code + " = " + country.name.common);
                        }
                       // Log.d("test", response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<List<Country>> call, Throwable throwable) {
                        Log.d("test", "ERROR");
                    }
                });
            }
        });
    }
}