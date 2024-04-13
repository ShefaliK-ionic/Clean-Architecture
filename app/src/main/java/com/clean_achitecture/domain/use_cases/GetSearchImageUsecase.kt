package com.clean_achitecture.domain.use_cases

import com.clean_achitecture.domain.model.Hits
import com.clean_achitecture.domain.model.ImageModel
import com.clean_achitecture.domain.repository.ApiRepository
import com.clean_achitecture.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.http.Query
import javax.inject.Inject

class GetSearchImageUsecase @Inject constructor(private val imRepository: ApiRepository) {

    operator fun invoke(query: String,token: String ): Flow<Resource<List<Hits>>> = flow{

     emit(Resource.Loading())
        try {
            emit(Resource.Success(imRepository.getImageData(query,token)))
        }catch (e:Exception){
            emit(Resource.error(message =e.message.toString()))
        }
    }

}