package com.kulya.dev.testproject.ui.main.view

import android.support.v7.app.AppCompatActivity
import com.kulya.dev.testproject.data.Country
import com.kulya.dev.testproject.scopes.PerActivity
import com.kulya.dev.testproject.scopes.PerFragment
import com.kulya.dev.testproject.ui.common.BaseActivityModule
import com.kulya.dev.testproject.ui.country.view.CountryFragment
import com.kulya.dev.testproject.ui.country.view.CountryFragmentModule
import com.kulya.dev.testproject.ui.main.presenter.MainPresenterModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [
    MainPresenterModule::class,
    BaseActivityModule::class
])
abstract class MainActivityModule {


    @PerFragment
    @ContributesAndroidInjector(modules = [CountryFragmentModule::class])
    abstract fun provideCountryFragment(): CountryFragment

    @Binds
    @PerActivity
    abstract fun provideMainView(mainActivity: MainActivity) : MainView


    @Binds
    @PerActivity
    abstract fun appCompatActivity(mainActivity: MainActivity): AppCompatActivity

}