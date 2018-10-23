package com.kulya.dev.testproject

import android.app.Application
import com.kulya.dev.testproject.scopes.PerActivity
import com.kulya.dev.testproject.ui.main.view.MainActivity
import com.kulya.dev.testproject.ui.main.view.MainActivityModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Module(includes = [AndroidSupportInjectionModule::class])
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun application(app: App): Application

    @PerActivity
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivityInjector(): MainActivity


}