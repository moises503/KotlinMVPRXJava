package com.moises.kotlinmvp.main.presenter

import com.moises.kotlinmvp.api.model.ResultsItem
import com.moises.kotlinmvp.main.contract.MainContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainPresenterImpl(val view: MainContract.View, val interactor: MainContract.Interactor) : MainContract.Presenter {

    private var subscription : Disposable? = null

    override fun getMoviesTopRated() {
        subscription = interactor.attemptMoviesTopRated()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.showMoviesTopRated(it.results as List<ResultsItem>)
                }, {
                    view.showMessage(it.message as String)
                }, {
                    view.showMessage("Lista de películas cargada")
                })
    }

    override fun onDestroy() {
        subscription?.let {
            if (!it.isDisposed) {
              it.dispose()
            }
        }
    }
}