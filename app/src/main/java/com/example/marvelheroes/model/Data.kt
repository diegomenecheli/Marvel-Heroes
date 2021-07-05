package com.example.marvelheroes.model

import java.io.Serializable

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: MutableList<SuperHeroes>,
    val total: Int
) : Serializable