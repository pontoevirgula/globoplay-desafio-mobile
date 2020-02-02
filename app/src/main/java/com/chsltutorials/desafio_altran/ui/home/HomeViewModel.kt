package com.chsltutorials.desafio_altran.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chsltutorials.desafio_altran.model.entity.Results
import com.chsltutorials.desafio_altran.model.repository.MovieRepositoryImpl
import kotlinx.coroutines.launch

class HomeViewModel(val repositoryImpl: MovieRepositoryImpl) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
    var moviesLiveData : MutableLiveData<List<Results>> = MutableLiveData()

    private val _requestStatus = MutableLiveData<RequestStatus>()
    val requestStatus: MutableLiveData<RequestStatus>
        get() = _requestStatus

    private val listMovies  = repositoryImpl.getListMovies()

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        viewModelScope.launch {
            try {
                _requestStatus.postValue(RequestStatus.LOADING)
                //repositoryImpl.getMovies()
                val teste = repositoryImpl.getMovies()

                if (!listMovies.isNullOrEmpty()) {
                    val movieList: MutableList<Results> = mutableListOf()
                    for (results in listMovies) {
                        movieList.add(results)
                    }
                    moviesLiveData.value = movieList
                }
                _requestStatus.postValue(RequestStatus.LOADED)
            } catch (e: Exception) {
                _requestStatus.postValue(RequestStatus.error(e.message))
                Log.e("Erro buscar filme", e.message!!)
            }
        }
    }
}
