package com.clean_achitecture.domain.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class ApiResponse (

    @SerializedName("total"     ) var total     : Int?            = null,
    @SerializedName("totalHits" ) var totalHits : Int?            = null,
    @SerializedName("hits"      ) var hits      : ArrayList<Hits> = ArrayList()

)

