package com.chsltutorials.desafio_altran.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.chsltutorials.desafio_altran.BuildConfig.IMAGE
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.chsltutorials.desafio_altran.R
import com.chsltutorials.desafio_altran.model.entity.Favorite
import com.chsltutorials.desafio_altran.model.entity.Results
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity: AppCompatActivity() {

    private val viewModel: DetailViewModel by viewModel()
    private var movie: Results? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        movie = intent?.extras?.get("MOVIE") as Results
    }

    override fun onResume() {
        super.onResume()

        movie?.id?.let { viewModel.checkFavorite(movie?.id.toString())}
        viewModel.checkFavorite(movie?.id.toString()).observe(this, Observer { movie ->
            if(movie != null){
                showCheck()
            }else{
                hideCheck()
            }
        })

        Picasso.with(this)
            .load(IMAGE +movie?.poster_path)
            .into(ivDetailImage)

        Picasso.with(this)
            .load(IMAGE +movie?.backdrop_path)
            .transform(BlurTransformation(this, 25, 1))
            .into(ivDetailImageBlur)

        tvDetailTitle.text = movie?.title

        btDetailFavorite.setOnClickListener {
            movie?.id?.let { movieId ->
                val favorite = Favorite(movieId)
                viewModel.addFavorite(favorite)
            }
        }

        btDetailFavoriteCheck.setOnClickListener {
            movie?.id?.let { movieId ->
                viewModel.removeFavorite(movieId.toString())
            }
        }

    }

    fun showCheck(){
        btDetailFavoriteCheck.visibility = View.VISIBLE
        btDetailFavorite.visibility = View.INVISIBLE
    }

    fun hideCheck(){
        btDetailFavorite.visibility = View.VISIBLE
        btDetailFavoriteCheck.visibility = View.INVISIBLE
    }
}
