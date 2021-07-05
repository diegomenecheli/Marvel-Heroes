package com.example.marvelheroes.model

import java.io.Serializable

data class Url(
    val type: String,
    val url: String
) : Serializable