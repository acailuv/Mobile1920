package com.github.acailuv.meeting08_trackmymoviequality.movietracker

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.acailuv.meeting08_trackmymoviequality.database.MovieDatabaseDao

class MovieTrackerViewModelFactory (
    private val dataSource: MovieDatabaseDao,
    private val application: Application,
    private val currentCardId: Long = 0L) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override  fun <T : ViewModel?> create (modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieTrackerViewModel::class.java)) {
            return MovieTrackerViewModel(dataSource, application) as T
        } else if (modelClass.isAssignableFrom(ViewMovieDetailsFragmentViewModel::class.java)) {
            return ViewMovieDetailsFragmentViewModel(dataSource, currentCardId, application) as T
        }
        throw IllegalAccessException("ViewModel class not recognized.")
    }

}