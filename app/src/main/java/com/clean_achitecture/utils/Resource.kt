package com.clean_achitecture.utils

sealed class Resource<T>(val data:T?=null, val message:String?=null){


    class Success<T>(data: T?):Resource<T>(data=data)
    class Loading<T>():Resource<T>()
    class error<T>(message: String?):Resource<T>(message=message)

}