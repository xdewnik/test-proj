package com.kulya.dev.testproject.ui.country.interactor

import com.kulya.dev.testproject.scopes.PerFragment
import dagger.Binds
import dagger.Module

@Module
abstract class CountryInteractorModule {

    @Binds
    @PerFragment
    abstract fun provideInteractor(countryInteractor: CountryInteractorImpl):CountryInteractor

}
