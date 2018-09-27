package com.moises.kotlinmvp.main.di

import com.moises.kotlinmvp.core.CoreModule
import com.moises.kotlinmvp.main.contract.MainContract
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(MainModule::class, CoreModule::class))
interface MainComponent {
    fun getPresenter() : MainContract.Presenter
}