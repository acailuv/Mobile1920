package com.github.acailuv.meeting08_trackmymoviequality.movietracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.github.acailuv.meeting08_trackmymoviequality.database.Movie
import com.github.acailuv.meeting08_trackmymoviequality.database.MovieDatabaseDao
import com.github.acailuv.meeting08_trackmymoviequality.formatMovies
import kotlinx.coroutines.*

class MovieTrackerViewModel (
    val database: MovieDatabaseDao,
    application: Application) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _navigateToMovieDetails = MutableLiveData<Movie>()
    val navigateToMovieDetails: LiveData<Movie>
        get() = _navigateToMovieDetails

    private val _navigateToMovieUpdate = MutableLiveData<Movie>()
    val navigateToMovieUpdate: LiveData<Movie>
        get() = _navigateToMovieUpdate

    private val movies = database.getAllMovies()
    val moviesString = Transformations.map(movies) { movies ->
        formatMovies(movies, application.resources)
    }

    fun onAddMovie() {
        uiScope.launch {
            val newMovie = Movie()
            _navigateToMovieDetails.value = newMovie
        }
    }

    fun onUpdateMovie() {
        uiScope.launch {
            val newMovie = Movie()
            _navigateToMovieUpdate.value = newMovie
        }
    }

    private suspend fun insert(movie: Movie) {
        withContext(Dispatchers.IO) {
            database.insert(movie)
        }
    }

    fun onClear() {
        uiScope.launch {
            clear()
        }
    }

    private suspend fun clear() {
        withContext(Dispatchers.IO) {
            database.clear()
        }
    }

    fun doneNavigating() {
        _navigateToMovieDetails.value = null
        _navigateToMovieUpdate.value = null
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}