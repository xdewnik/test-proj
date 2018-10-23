package com.kulya.dev.testproject.ui.country.interactor

import com.kulya.dev.testproject.data.Country
import com.kulya.dev.testproject.network.ApiServices
import com.kulya.dev.testproject.ui.common.interactor.BaseInteractor
import io.reactivex.Observable
import javax.inject.Inject

class CountryInteractorImpl @Inject constructor(
    api:ApiServices
):BaseInteractor(api), CountryInteractor {
    override fun getCountryList(): Observable<MutableList<Country>> {
        return api.getAllCountries()
    }
}