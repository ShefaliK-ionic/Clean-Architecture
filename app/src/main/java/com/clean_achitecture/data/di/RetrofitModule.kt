package com.clean_achitecture.data.di

import com.clean_achitecture.data.network.ApiInterface

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RetrofitModule {


    private const val readTime: Long = 60
    private const val writeTime: Long = 60
    private const val connectionTime: Long = 2
    @Provides
    @Named("mainUrl")
    fun provideBaseUrl()="https://pixabay.com/";

    @Provides
    fun provideApiService(@Named("mainUrl") baseUrl:String)
            :ApiInterface=
        Retrofit.Builder().
        baseUrl(baseUrl).
        addConverterFactory(GsonConverterFactory.create()).
        build()
            .create(ApiInterface::class.java)

}
