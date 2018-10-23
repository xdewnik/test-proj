package com.kulya.dev.testproject.ui.country.view

import android.support.v4.app.Fragment
import com.kulya.dev.testproject.scopes.PerFragment
import com.kulya.dev.testproject.ui.common.view.BaseFragmentModule
import com.kulya.dev.testproject.ui.country.presenter.CountryPresenterModule
import dagger.Binds
import dagger.Module

@Module(includes = [
    BaseFragmentModule::class,
    CountryPresenterModule::class
])
abstract class CountryFragmentModule {

    @Binds
    @PerFragment
    abstract fun provideFragment(countryFragment: CountryFragment): Fragment

    @Binds
    @PerFragment
    abstract fun provideView(countryFragment: CountryFragment): CountryFragmentView

}