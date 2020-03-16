package com.peterstev.nc_flightradar.interfaces;

import android.content.Context;

import com.readystatesoftware.chuck.ChuckInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.peterstev.nc_flightradar.utils.Constants.BASE_URL;

public class ApiServiceGenerator {

    //synchronize class for optimisation
    private static OkHttpClient getClient(Context context) {
        return new OkHttpClient.Builder()
                .connectTimeout(90, TimeUnit.SECONDS)
                .readTimeout(90, TimeUnit.SECONDS)
                .writeTimeout(90, TimeUnit.SECONDS)
                .addInterceptor(new ChuckInterceptor(context))
                .build();
    }

    public static ApiInterface getRetrofit(Context context) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(getClient(context))
                .build();

        return retrofit.create(ApiInterface.class);
    }


}
