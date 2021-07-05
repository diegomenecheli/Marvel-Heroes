package com.example.marvelheroes.model

import java.io.Serializable

data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXXX>,
    val returned: Int
) : Serializable