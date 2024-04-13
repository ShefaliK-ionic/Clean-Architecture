package com.clean_achitecture.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clean_achitecture.domain.model.Hits
import com.clean_achitecture.domain.use_cases.GetSearchImageUsecase
import com.clean_achitecture.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageViewmodel @Inject constructor(val getSearchImageUsecase: GetSearchImageUsecase):ViewModel() {

    private var _dashboard = MutableStateFlow<Resource<List<Hits>>>(Resource.Loading())
    val dashboard: StateFlow<Resource<List<Hits>>> = _dashboard

    fun fetchDashBoard(query: String,token:String){
        viewModelScope.launch {
            getSearchImageUsecase.invoke(query,token).collect{
                _dashboard.value = it
            }
        }
    }


}