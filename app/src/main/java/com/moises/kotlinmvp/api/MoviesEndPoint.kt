package com.moises.kotlinmvp.api

import com.moises.kotlinmvp.api.model.Response
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesEndPoint {

    @GET("top_rated")
    fun geTopRated(@Query("page") page : Int) : Observable<Response>


}