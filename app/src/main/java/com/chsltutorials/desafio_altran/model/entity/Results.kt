package com.chsltutorials.desafio_altran.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "movies")
data class Results(
    val popularity: Float ? = 0F,
    @PrimaryKey val id: Int ? = 0,
    val video: Boolean = false,
    val vote_count: Int ? = 0,
    val vote_average: Float ? = 0F,
    val title: String? = null,
    val release_date: String? = null,
    val original_language: String? = null,
    val original_title: String? = null,
    val backdrop_path: String? = null,
    val adult: Boolean = false,
    val overview: String? = null,
    val poster_path: String? = null
): Serializable