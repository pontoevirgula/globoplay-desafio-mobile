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

class HomeAdapter (private val context: Context, private val movies: List<Results>, private val onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<HomeAdapter.MovieViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_movie_item, parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        Picasso.with(context)
            .load(BuildConfig.IMAGE+movies[position].poster_path)
            .into(holder.itemView.ivMovieImage)
        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClick(position)
        }
    }

    override fun getItemCount() = movies.size

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}