package com.example.marvelheroes.model

import java.io.Serializable

data class Item(
    val name: String,
    val resourceURI: String
) : Serializable