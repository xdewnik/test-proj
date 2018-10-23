package com.kulya.dev.testproject.network

import com.kulya.dev.testproject.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton


@Module
class ApiModule {


    @Singleton
    @Provides
    @Named("baseUrl")
    fun baseEndpoint() = ApiConstants.BASE_URL


    @Singleton
    @Provides
    fun intercepter() = ApiInterceptor()

    @Singleton
    @Provides
    fun provideOkHttpBuilder(): OkHttpClient.Builder {
        val okHttpBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            okHttpBuilder.addInterceptor(logging)
        }
        return okHttpBuilder.apply {
            readTimeout(15.toLong(), TimeUnit.SECONDS)
            connectTimeout(15.toLong(), TimeUnit.SECONDS)
        }
    }


    @Singleton
    @Provides
    @Named("baseRetrofit")
    fun provideRetrofit(retrofitBuilder: Retrofit.Builder,
                            okHttpClientBuilder: OkHttpClient.Builder,
                            interceptor: ApiInterceptor,
                            @Named("baseUrl") baseUrl: String): Retrofit {
        return retrofitBuilder
            .client(okHttpClientBuilder.addInterceptor(interceptor).build())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    }

    @Singleton
    @Provides
    fun provideApiService(@Named("baseRetrofit") retrofit: Retrofit): ApiServices{
        return retrofit.create(ApiServices::class.java)
    }


}