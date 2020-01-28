package com.chsltutorials.desafio_altran.model.entity

data class MovieResponse(
    val page: Int ? = 0,
    val total_results: Int ? = 0,
    val total_pages: Int ? = 0,
    val results : List<Results>? = null
)
