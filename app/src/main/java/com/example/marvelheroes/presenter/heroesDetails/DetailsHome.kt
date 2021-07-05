package com.example.marvelheroes.presenter.heroesDetails

import com.example.marvelheroes.model.SuperHeroes

interface DetailsHome {
    interface Presenter{
        fun onSuccess(heroes: SuperHeroes)
    }
}