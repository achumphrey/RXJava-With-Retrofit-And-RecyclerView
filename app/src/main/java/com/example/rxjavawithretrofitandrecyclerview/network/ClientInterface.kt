package com.example.rxjavawithretrofitandrecyclerview.network

import com.example.rxjavawithretrofitandrecyclerview.model.StarWarsModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET


interface ClientInterface {

    @GET("api/people/")
    fun getNewsRecords(): Observable<StarWarsModel>
}




