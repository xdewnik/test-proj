package com.kulya.dev.testproject.ui.common

import android.app.Activity
import android.content.Context
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.kulya.dev.testproject.scopes.PerActivity
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class BaseActivityModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        @PerActivity
        fun activityFragmentManager(activity: AppCompatActivity): FragmentManager =
            activity.supportFragmentManager
    }

    @Binds
    @PerActivity
    abstract fun activity(appCompatActivity: AppCompatActivity): Activity

    @Binds
    @PerActivity
    abstract fun activityContext(activity: Activity): Context

}