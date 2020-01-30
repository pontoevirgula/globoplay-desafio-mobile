package com.chsltutorials.desafio_altran.ui.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.chsltutorials.desafio_altran.R
import com.chsltutorials.desafio_altran.ui.details.DetailActivity
import com.chsltutorials.desafio_altran.ui.home.HomeAdapter
import com.chsltutorials.desafio_altran.ui.util.SpacingItemDecoration
import kotlinx.android.synthetic.main.fragment_favorite.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment() {

    private val viewModel: FavoriteViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_favorite, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.listFavoriteMovies.observe(this, Observer { movies ->
            favorite_recycler_view.layoutManager = GridLayoutManager(activity, 3)
            val spacingInPixels = resources.getDimensionPixelSize(R.dimen.grid4)
            favorite_recycler_view.addItemDecoration(
                SpacingItemDecoration(
                    spacingInPixels
                )
            )
            context?.let {
                favorite_recycler_view.adapter =
                    HomeAdapter(
                        it,
                        movies,
                        object :
                            HomeAdapter.OnItemClickListener {
                            override fun onItemClick(position: Int) {
                                val intent = Intent(activity, DetailActivity::class.java)
                                intent.putExtra("MOVIE", movies[position])
                                startActivity(intent)
                            }
                        }
                    )
            }
        })
    }
}