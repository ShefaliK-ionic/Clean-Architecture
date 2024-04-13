package com.clean_achitecture.utils

import com.clean_achitecture.domain.model.Hits
import com.clean_achitecture.domain.model.ImageModel

fun Hits.toDomainModel():ImageModel {
    return ImageModel(largeImageURL = this.largeImageURL!!)
}
