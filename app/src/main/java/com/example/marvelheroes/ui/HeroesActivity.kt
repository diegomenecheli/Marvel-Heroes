package com.example.marvelheroes.ui

import android.content.Intent
import coil.load
import com.example.marvelheroes.R
import com.example.marvelheroes.model.SuperHeroes
import com.example.marvelheroes.model.data.HeroesDataSource
import com.example.marvelheroes.presenter.ViewHome
import com.example.marvelheroes.presenter.heroesDetails.DetailsPresenter
import kotlinx.android.synthetic.main.activity_heroes.*
import okhttp3.HttpUrl.Companion.toHttpUrl

class HeroesActivity : AbstractActivity(), ViewHome.Details {

    private lateinit var heroes: SuperHeroes
    private lateinit var presenter: DetailsPresenter

    override fun getLayout(): Int = R.layout.activity_heroes

    override fun onInject() {
        getHeroesDetails()
        showHeroesDetails(heroes)
        val dataSource = HeroesDataSource(this)
        presenter = DetailsPresenter(this, dataSource)
        clickBackButton()
    }

    private fun getHeroesDetails() {
        intent.extras?.let { articleSent ->
            heroes = articleSent.get("heroes") as SuperHeroes
        }
    }

    override fun showHeroesDetails(heroes: SuperHeroes) {
        tvName.text = heroes.name
        if (heroes.description != "") {
            tvDescription.text = heroes.description
        }
        val httpsPath = if (heroes.thumbnail.path.startsWith("https")) heroes.thumbnail.path
        else heroes.thumbnail.path.replaceFirst("http", "https")
        val httpsExt = heroes.thumbnail.extension
        val imageUrl = "$httpsPath.${httpsExt}".toHttpUrl()
        ivHero.load(imageUrl)
    }

    private fun clickBackButton(){
        back_button.setOnClickListener {
            super.onBackPressed()
        }
    }
}