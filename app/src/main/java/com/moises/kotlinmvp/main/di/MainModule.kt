package com.moises.kotlinmvp.main.di

import com.moises.kotlinmvp.main.contract.MainContract
import com.moises.kotlinmvp.main.interactor.MainInteractorImpl
import com.moises.kotlinmvp.main.presenter.MainPresenterImpl
import com.moises.kotlinmvp.main.repository.MainRepositoryImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class MainModule(var view : MainContract.View){

    @Provides
    @Singleton
    fun providesMainView() : MainContract.View {
        return view
    }

    @Provides
    @Singleton
    fun providesPresenter(view: MainContract.View, interactor: MainContract.Interactor) : MainContract.Presenter {
        return MainPresenterImpl(view, interactor)
    }

    @Provides
    @Singleton
    fun providesInteractor(repository: MainContract.Repository) : MainContract.Interactor {
        return MainInteractorImpl(repository)
    }

    @Provides
    @Singleton
    fun providesRepository(retrofit: Retrofit) : MainContract.Repository {
        return MainRepositoryImpl(retrofit)
    }
}