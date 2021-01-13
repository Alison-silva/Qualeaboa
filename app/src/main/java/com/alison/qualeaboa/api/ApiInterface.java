package com.alison.qualeaboa.api;

import com.alison.qualeaboa.model.Estab;
import com.alison.qualeaboa.model.Party;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("establishment.php")
    Call<List<Estab> > getLocals(
            @Query("key") String keyword
    );

    @GET("party.php")
    Call<List<Party> > getEvents(
            @Query("key") String keyword
    );
}
