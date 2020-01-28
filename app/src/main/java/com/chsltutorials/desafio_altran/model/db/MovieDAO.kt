package com.chsltutorials.desafio_altran.model.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.chsltutorials.desafio_altran.model.entity.Favorite
import com.chsltutorials.desafio_altran.model.entity.Results

@Dao
interface MovieDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMovies(movies: List<Results>)

    @Query("SELECT * FROM movies")
    fun findAllMovies(): LiveData<List<Results>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSingleResult(result: Results)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGenreIds(genreIds: Results)

    @Transaction
    fun addMovie(result: Results) {
        insertGenreIds(result)
        insertSingleResult(result)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addFavoriteMovie(favorite: Favorite)

    @Query("Delete FROM favorite where id = :id")
    fun removeFavoriteMovies(id: String)

    @Query("SELECT * FROM movies where id in (select id from favorite)")
    fun findAllFavoriteMovies(): LiveData<List<Results>>

    @Query("SELECT * FROM favorite where id = :id")
    fun verifyFavoriteMovie(id: String): LiveData<Favorite>
}

@Database(entities = [Results::class, Favorite::class], version = 6, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun moviesDao(): MovieDAO
}
