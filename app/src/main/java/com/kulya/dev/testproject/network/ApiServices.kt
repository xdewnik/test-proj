package com.kulya.dev.testproject.network

import com.kulya.dev.testproject.data.Country
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiServices {



    @GET("all")
    fun getAllCountries(): Observable<MutableList<Country>>

}