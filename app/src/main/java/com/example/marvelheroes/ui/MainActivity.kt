package com.example.marvelheroes.ui

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelheroes.R
import com.example.marvelheroes.adapter.MainAdapter
import com.example.marvelheroes.model.SuperHeroes
import com.example.marvelheroes.model.data.HeroesDataSource
import com.example.marvelheroes.presenter.ViewHome
import com.example.marvelheroes.presenter.heroes.HeroesPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AbstractActivity(), ViewHome.View {

    private val mainAdapter by lazy {
        MainAdapter()
    }
    private lateinit var presenter: HeroesPresenter

    override fun getLayout(): Int = R.layout.activity_main

    override fun onInject() {
        val dataSource = HeroesDataSource(
            this
        )
        presenter = HeroesPresenter(this, dataSource)
        presenter.requestAll()
        configRecycler()
        clickAdapter()
    }

    private fun configRecycler() {
        with(recycler_main) {
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }


    override fun showProgressBar() {
        main_loading.visibility = View.VISIBLE
    }

    override fun showFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun hideProgressBar() {
        main_loading.visibility = View.INVISIBLE
    }

    override fun showHeroes(superHeroes: List<SuperHeroes>) {
        mainAdapter.differ.submitList(superHeroes.toList())
    }


    private fun clickAdapter() {
        mainAdapter.setOnClickListener { heroes ->
            val intent = Intent(this, HeroesActivity::class.java)
            intent.putExtra("heroes", heroes)
            startActivity(intent)
        }
    }

}