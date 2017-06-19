package com.veena.transportapp;

import com.veena.transportapp.model.Destination;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by veena on 14/06/17.
 */

public interface Travel {

    @GET("/sample.json")
    Call<List<Destination>> getDestinationList();
}
