package com.chsltutorials.desafio_altran.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chsltutorials.desafio_altran.BuildConfig
import com.chsltutorials.desafio_altran.R
import com.chsltutorials.desafio_altran.model.entity.Results
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_movie_item.view.*

class HomeAdapter (private val context: Context,
                   private val movies: MutableList<Results> = mutableListOf(),
                   private val onItemClick: (resultList : Results) -> Unit) : RecyclerView.Adapter<HomeAdapter.MovieViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =  LayoutInflater.from(context).inflate(R.layout.adapter_movie_item, parent, false)
        return MovieViewHolder(view, onItemClick)
    }

//    fun replaceAllMovies(movieList: List<Results>) {
//        movies.clear()
//        movies.addAll(movieList)
//        notifyDataSetChanged()
//    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount() = movies.size

    inner class MovieViewHolder(itemView: View, private val onItemClick: (resultList : Results) -> Unit) : RecyclerView.ViewHolder(itemView) {

        fun bind(results: Results) {
            val image = BuildConfig.IMAGE+results.poster_path
            val a = image
            Picasso.with(context)
                .load(image)
                .into(itemView.ivMovieImage)

            itemView.setOnClickListener {
                onItemClick.invoke(results)
            }
        }
    }


}