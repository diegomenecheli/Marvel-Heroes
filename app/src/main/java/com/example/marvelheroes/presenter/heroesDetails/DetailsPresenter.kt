package com.example.marvelheroes.presenter.heroesDetails

import com.example.marvelheroes.model.SuperHeroes
import com.example.marvelheroes.model.data.HeroesDataSource
import com.example.marvelheroes.presenter.ViewHome


class DetailsPresenter(
    val view: ViewHome.Details,
    private val dataSource: HeroesDataSource
) : DetailsHome.Presenter {
    override fun onSuccess(heroes: SuperHeroes) {
        this.view.showHeroesDetails(heroes)
    }

}