package com.moises.kotlinmvp

import android.app.Activity
import android.app.Application
import com.moises.kotlinmvp.core.CoreModule
import com.moises.kotlinmvp.main.contract.MainContract
import com.moises.kotlinmvp.main.di.DaggerMainComponent
import com.moises.kotlinmvp.main.di.MainComponent
import com.moises.kotlinmvp.main.di.MainModule

class KotlinMVPApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    fun getMainComponent(activity: Activity, view: MainContract.View) : MainComponent {
        return DaggerMainComponent
                .builder()
                .coreModule(CoreModule(activity))
                .mainModule(MainModule(view))
                .build()
    }
}