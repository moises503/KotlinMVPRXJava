package com.moises.kotlinmvp.main.interactor

import com.moises.kotlinmvp.api.model.Response
import com.moises.kotlinmvp.main.contract.MainContract
import io.reactivex.Observable

class MainInteractorImpl(val repository: MainContract.Repository) : MainContract.Interactor{

    override fun attemptMoviesTopRated(): Observable<Response> {
        return repository.attemptMoviesTopRated()
    }
}