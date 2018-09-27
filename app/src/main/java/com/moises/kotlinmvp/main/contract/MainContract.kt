package com.moises.kotlinmvp.main.contract

import com.moises.kotlinmvp.api.model.Response
import com.moises.kotlinmvp.api.model.ResultsItem
import io.reactivex.Observable

interface MainContract {
    interface View {
        fun showMoviesTopRated(resultItems : List<ResultsItem>)
        fun showMessage(message : String)
    }

    interface Presenter {
        fun getMoviesTopRated()
        fun onDestroy()
    }

    interface Interactor {
        fun attemptMoviesTopRated() : Observable<Response>
    }

    interface Repository {
        fun attemptMoviesTopRated() : Observable<Response>
    }
}