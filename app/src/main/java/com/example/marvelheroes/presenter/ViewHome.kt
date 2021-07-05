package com.example.marvelheroes.presenter

import com.example.marvelheroes.model.SuperHeroes

interface ViewHome {

    interface View {
        fun showProgressBar()
        fun showFailure(message: String)
        fun hideProgressBar()
        fun showHeroes(superHeroes: List<SuperHeroes>)
    }

    interface Details {
        fun showHeroesDetails(heroes: SuperHeroes)
    }

    interface Search {
        fun showProgressBar()
        fun showFailure(message: String)
        fun hideProgressBar()
        fun showHeroesSearch(term: String, heroes: SuperHeroes)
    }
}