package com.clean_achitecture.di

import com.clean_achitecture.data.remote.ApiInterface
import com.clean_achitecture.data.repository.ApiRepositoryImpl
import com.clean_achitecture.domain.repository.ApiRepository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

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



    @Provides
    fun provideDataRepo(apiInterface: ApiInterface): ApiRepository {
        return ApiRepositoryImpl(apiInterface)

    }
}
