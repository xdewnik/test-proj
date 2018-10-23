package com.kulya.dev.testproject.ui.country.view

import com.kulya.dev.testproject.data.Country
import com.kulya.dev.testproject.ui.common.view.MVPView

interface CountryFragmentView : MVPView{

    fun startLoading()
    fun finishLoading()
    fun onError(message: String?)
    fun populateList(countryList: MutableList<Country>)
}