package com.kulya.dev.testproject.ui.country.interactor

import com.kulya.dev.testproject.data.Country
import com.kulya.dev.testproject.ui.common.interactor.Interactor
import io.reactivex.Observable

interface CountryInteractor: Interactor {

    fun getCountryList(): Observable<MutableList<Country>>
}