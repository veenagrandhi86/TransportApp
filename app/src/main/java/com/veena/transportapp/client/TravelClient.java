package com.veena.transportapp.client;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by veena on 14/06/17.
 */

public class TravelClient {

    private static final String BASE_URL = "http://express-it.optusnet.com.au";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit;
    }

}
