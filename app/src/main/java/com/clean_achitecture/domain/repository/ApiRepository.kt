package com.clean_achitecture.domain.repository

import com.clean_achitecture.domain.model.Hits
import com.clean_achitecture.domain.model.ImageModel
import retrofit2.http.Query

interface ApiRepository {

    suspend fun getImageData(query: String,token: String):List<Hits>

}