package com.github.acailuv.meeting08_trackmymoviequality.movietracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.github.acailuv.meeting08_trackmymoviequality.database.Movie
import com.github.acailuv.meeting08_trackmymoviequality.database.MovieDatabaseDao
import kotlinx.coroutines.*

class ViewMovieDetailsFragmentViewModel (
    val database: MovieDatabaseDao,
    val currentMovieId: Long,
    application: Application
) : AndroidViewModel(application) {

    val job = Job()
    val uiScope = CoroutineScope(Dispatchers.Main + job)

    var currentMovie = MutableLiveData<Movie>()
    init {
        initializeCurrentCardData()
    }

    fun initializeCurrentCardData() {
        uiScope.launch {
            currentMovie.value = withContext(Dispatchers.IO) {
                database.get(currentMovieId)
            }
        }
    }
}