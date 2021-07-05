package com.example.marvelheroes.presenter.heroes

import com.example.marvelheroes.model.HeroesResponse


interface HeroesHome {

    interface Presenter {
        fun requestAll()
        fun onSuccess(heroesResponse: HeroesResponse)
        fun onError(message: String)
        fun onComplete()
    }
}