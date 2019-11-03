package com.example.kuwait.Util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit==null) {


//http://webhose.io/filterWebContent?token=788d850d-7411-4de4-9fcc-784f0856bf36&format=json&sort=crawled&q=Mo%20Salah
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://webhose.io")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }

        return retrofit;
    }
}
