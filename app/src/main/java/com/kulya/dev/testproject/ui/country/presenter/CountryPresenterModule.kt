package com.kulya.dev.testproject.ui.country.presenter

import com.kulya.dev.testproject.scopes.PerFragment
import com.kulya.dev.testproject.ui.country.interactor.CountryInteractorModule
import dagger.Binds
import dagger.Module

@Module(includes = [
    CountryInteractorModule::class
])
abstract class CountryPresenterModule {


    @Binds
    @PerFragment
    abstract fun providePresenter(countryPresenter: CountryPresenterImpl):CountryPresenter

}