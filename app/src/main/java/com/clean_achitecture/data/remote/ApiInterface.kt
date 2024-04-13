package com.clean_achitecture.data.remote

import com.clean_achitecture.domain.model.ApiResponse
import retrofit2.http.*


//const val BASE_URL=
interface ApiInterface {

    //https://pixabay.com/api/?key=43273217-5998d18a51a9dfe7084ec890d&q=flower&pretty=true
    @GET("api/")
    suspend fun getSearchImage(@Query("key") key:String,
                               @Query("q") q:String,
                               ): ApiResponse


}