package com.clean_achitecture.data.repository

import com.clean_achitecture.data.remote.ApiInterface
import com.clean_achitecture.domain.model.Hits
import com.clean_achitecture.domain.model.ImageModel
import com.clean_achitecture.domain.repository.ApiRepository

class ApiRepositoryImpl(private val apiInterface: ApiInterface) :ApiRepository {

    override suspend fun getImageData(query: String,token: String): List<Hits> {
        try {
          return apiInterface.getSearchImage("43273217-5998d18a51a9dfe7084ec890d",query).hits
        }catch (e:Exception){
            throw Exception(e)
        }

    }


}