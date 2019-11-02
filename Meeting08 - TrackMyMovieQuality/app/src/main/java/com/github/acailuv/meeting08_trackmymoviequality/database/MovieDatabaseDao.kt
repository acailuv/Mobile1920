package com.github.acailuv.meeting08_trackmymoviequality.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MovieDatabaseDao {
    @Insert
    fun insert(movie: Movie)

    @Update
    fun update(movie: Movie)

    @Query ("SELECT * FROM movie_rating_table WHERE movieId = :key")
    fun get(key: Long): Movie?

    @Query ("SELECT movie_name FROM movie_rating_table WHERE movieId = :key")
    fun getMovieName(key: Long): String?

    @Query ("SELECT rating FROM movie_rating_table WHERE movieId = :key")
    fun getMovieRating(key: Long): Int?

    @Query ("DELETE FROM movie_rating_table")
    fun clear()

    @Query ("SELECT * FROM movie_rating_table ORDER BY movie_name")
    fun getAllMovies(): LiveData<List<Movie>>

    @Query ("UPDATE movie_rating_table SET movie_name = :newMovieName, rating = :newRating WHERE movieId = :key")
    fun forceUpdate(key: Long, newMovieName: String, newRating: Int)
}