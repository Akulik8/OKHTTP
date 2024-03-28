package com.example.okhttp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CountryApi {
    @GET("all?fields=cca2,name,flags")
    Call<List<Country>> getAllCountry();

    @GET("alpha/{code}?fields=cca2, name, flags")
    Call<Country> getCountry(@Path("code") String code);
}
