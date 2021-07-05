package com.example.marvelheroes.model

import java.io.Serializable

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemX>,
    val returned: Int
) : Serializable