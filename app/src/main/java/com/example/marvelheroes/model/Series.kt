package com.example.marvelheroes.model

import java.io.Serializable

data class Series(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXX>,
    val returned: Int
) : Serializable