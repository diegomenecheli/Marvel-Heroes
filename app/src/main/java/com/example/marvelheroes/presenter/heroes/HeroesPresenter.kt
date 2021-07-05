package com.example.marvelheroes.presenter.heroes

import com.example.marvelheroes.model.HeroesResponse
import com.example.marvelheroes.model.data.HeroesDataSource
import com.example.marvelheroes.presenter.ViewHome


class HeroesPresenter(
    val view: ViewHome.View,
    private val dataSource: HeroesDataSource
) : HeroesHome.Presenter {

    override fun requestAll() {
        this.view.showProgressBar()
        this.dataSource.getHeroes(this)
    }

    override fun onSuccess(heroesResponse: HeroesResponse) {
        this.view.showHeroes(heroesResponse.data.results)
    }

    override fun onError(message: String) {
        this.view.showFailure(message)
    }

    override fun onComplete() {
        this.view.hideProgressBar()
    }

}