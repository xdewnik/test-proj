package com.kulya.dev.testproject.ui.main.presenter

import com.kulya.dev.testproject.scopes.PerActivity
import dagger.Binds
import dagger.Module

@Module
abstract class MainPresenterModule {

    @Binds
    @PerActivity
    abstract fun provideMainPresenter(mainPresenter: MainPresenterImpl): MainPresenter

}