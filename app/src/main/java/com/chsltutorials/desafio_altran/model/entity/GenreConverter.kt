package com.chsltutorials.desafio_altran.model.entity

import androidx.room.TypeConverter
import com.google.gson.Gson

class GenreConverter {

    @TypeConverter
    fun listToJson(value: List<GenreID>?): String {

        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String): List<GenreID>? {

        val objects = Gson().fromJson(value, Array<GenreID>::class.java) as Array<GenreID>
        return objects.toList()
    }
}