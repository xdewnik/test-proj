package com.kulya.dev.testproject

import android.app.Activity
import android.app.Application
import android.content.Context
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().create(this).inject(this)
    }

    override fun activityInjector() = activityInjector


}