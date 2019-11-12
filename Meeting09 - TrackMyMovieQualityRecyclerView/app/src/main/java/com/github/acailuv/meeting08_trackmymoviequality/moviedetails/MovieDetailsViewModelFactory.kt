package com.github.acailuv.meeting08_trackmymoviequality.moviedetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.acailuv.meeting08_trackmymoviequality.database.MovieDatabaseDao

class MovieDetailsViewModelFactory (
    private val movieKey: Long,
    private val dataSource: MovieDatabaseDao) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieDetailsViewModel::class.java)) {
            return MovieDetailsViewModel(movieKey, dataSource) as T
        }
        throw IllegalAccessException("ViewModel class not recognized.")
    }

}