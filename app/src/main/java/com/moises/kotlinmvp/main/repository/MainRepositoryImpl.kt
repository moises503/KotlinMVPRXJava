package com.moises.kotlinmvp.main.repository

import com.moises.kotlinmvp.api.MoviesEndPoint
import com.moises.kotlinmvp.api.model.Response
import com.moises.kotlinmvp.main.contract.MainContract
import io.reactivex.Observable
import retrofit2.Retrofit

class MainRepositoryImpl(val retrofit : Retrofit) : MainContract.Repository {

    override fun attemptMoviesTopRated(): Observable<Response> {
        return retrofit.create(MoviesEndPoint::class.java).geTopRated(1)
    }
}