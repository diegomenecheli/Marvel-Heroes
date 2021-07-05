package com.example.marvelheroes.model.data

import android.content.Context
import com.example.marvelheroes.network.RetrofitInstance
import com.example.marvelheroes.presenter.heroes.HeroesHome
import com.example.marvelheroes.util.Constants.Companion.PRIVATE_KEY
import com.example.marvelheroes.util.Constants.Companion.PUBLIC_KEY
import com.example.marvelheroes.util.md5
import kotlinx.coroutines.*

class HeroesDataSource(context: Context) {

    private val ts = System.currentTimeMillis()
    private var hash =
        "$ts$PRIVATE_KEY$PUBLIC_KEY".md5()

    fun getHeroes(callback: HeroesHome.Presenter) {
        GlobalScope.launch(Dispatchers.Main) {
            val response = RetrofitInstance.api.getHeroes(ts, hash)
            if (response.isSuccessful) {
                response.body()?.let { newsResponse ->
                    callback.onSuccess(newsResponse)
                }
                callback.onComplete()
            } else {
                callback.onError(response.message())
                callback.onComplete()
            }
        }
    }

}