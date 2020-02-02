package com.chsltutorials.desafio_altran.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.chsltutorials.desafio_altran.R
import com.chsltutorials.desafio_altran.model.entity.Results
import com.chsltutorials.desafio_altran.ui.details.DetailActivity
import com.chsltutorials.desafio_altran.ui.util.SpacingItemDecoration
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.moviesLiveData.observe(this, Observer { movies ->
            if (!movies.isNullOrEmpty()) {
                rvHome.layoutManager = GridLayoutManager(activity, 3)
                val spacingInPixels = resources.getDimensionPixelSize(R.dimen.grid4)
                rvHome.addItemDecoration(SpacingItemDecoration(spacingInPixels))

                context?.let {
                     val adapter = HomeAdapter(context!!, movies as MutableList<Results>) { movieClicked ->
                        val intent = DetailActivity.getStartIntent(it, movieClicked)
                        startActivity(intent)
                    }
                    //adapter.replaceAllMovies(movies as List<Results>)
                    rvHome.adapter = adapter
                }
            }
        })
    }


}
