package com.moises.kotlinmvp.main.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moises.kotlinmvp.R
import com.moises.kotlinmvp.api.model.ResultsItem
import kotlinx.android.synthetic.main.movie_item.view.*

class MoviesRecyclerViewAdapter (val movieList: List<ResultsItem>, val context : Context) : RecyclerView.Adapter<MoviesRecyclerViewAdapter.MovieHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder =
            MovieHolder(LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false))

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bindView(movieList[position])
    }

    class MovieHolder(itemView: View?) : RecyclerView.ViewHolder(itemView){
        fun bindView(resultItem : ResultsItem){
            with(resultItem){
                itemView.movie_language.text = originalLanguage
                itemView.movie_title.text = originalTitle
            }
        }
    }
}