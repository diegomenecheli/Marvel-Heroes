package com.example.marvelheroes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.marvelheroes.R
import com.example.marvelheroes.model.SuperHeroes
import kotlinx.android.synthetic.main.item_heroes.view.*
import okhttp3.HttpUrl.Companion.toHttpUrl

class MainAdapter : RecyclerView.Adapter<MainAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<SuperHeroes>() {
        override fun areItemsTheSame(oldItem: SuperHeroes, newItem: SuperHeroes): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: SuperHeroes, newItem: SuperHeroes): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val heroes = differ.currentList[position]
        //TODO EMPTY HERO IMAGE
        val httpsPath = if (heroes.thumbnail.path.startsWith("https")) heroes.thumbnail.path
        else heroes.thumbnail.path.replaceFirst("http", "https")
        val httpsExt = heroes.thumbnail.extension
        val imageUrl = "$httpsPath.${httpsExt}".toHttpUrl()
        holder.itemView.apply {
            tvSuperheroName.text = heroes.name
            ivSuperhero.load(imageUrl)
            setOnClickListener {
                onItemClickListener?.let { click ->
                    click(heroes)
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder =
        ArticleViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_heroes, parent, false)
        )

    override fun getItemCount(): Int = differ.currentList.size

    private var onItemClickListener: ((SuperHeroes) -> Unit)? = null

    fun setOnClickListener(listener: (SuperHeroes) -> Unit) {
        onItemClickListener = listener
    }
}