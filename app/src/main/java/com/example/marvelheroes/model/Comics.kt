package com.example.marvelheroes.model

import java.io.Serializable

data class Comics(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
) : Serializable