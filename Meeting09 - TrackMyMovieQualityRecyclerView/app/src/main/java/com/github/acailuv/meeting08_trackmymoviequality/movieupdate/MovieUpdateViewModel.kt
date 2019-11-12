package com.github.acailuv.meeting08_trackmymoviequality.movieupdate

import android.app.Application
import android.widget.EditText
import android.widget.RatingBar
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.github.acailuv.meeting08_trackmymoviequality.database.Movie
import com.github.acailuv.meeting08_trackmymoviequality.database.MovieDatabaseDao
import com.github.acailuv.meeting08_trackmymoviequality.formatMovies
import kotlinx.coroutines.*

class MovieUpdateViewModel (
    val database: MovieDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _navigateToMovieTracker = MutableLiveData<String>()
    val navigateToMovieTracker: LiveData<String>
        get() = _navigateToMovieTracker
//
//    private val _currentMovieName = MutableLiveData<String>()
//    val currentMovieName: LiveData<String>
//        get() = _currentMovieName
//
//    private val _currentMovieRating = MutableLiveData<Int>()
//    val currentMovieRating: LiveData<Int>
//        get() = _currentMovieRating

    fun onUpdateMovie(key: EditText, newMovieName: EditText, newMovieReview: EditText, newMovieRating: RatingBar) {
        when {
            key.text.toString() == "" -> _navigateToMovieTracker.value = "emptyKey"
            newMovieName.text.toString() == "" -> _navigateToMovieTracker.value = "emptyMovieName"
            newMovieRating.rating.toInt() == 0 -> _navigateToMovieTracker.value = "emptyRating"
            newMovieReview.text.toString() == "" -> _navigateToMovieTracker.value = "emptyReview"
            else -> {
                uiScope.launch {
                    val newMovie = withContext(Dispatchers.IO) {
                        val newMovie = database.get(key.text.toString().toLong()) ?: Movie()
                        return@withContext newMovie
                    }
                    if (newMovie == Movie()) {
                        _navigateToMovieTracker.value = "movieNotFound"
                    } else {
                        newMovie.movieName = newMovieName.text.toString()
                        newMovie.rating = newMovieRating.rating.toInt()
                        newMovie.review = newMovieReview.text.toString()
                        update(newMovie)
                        _navigateToMovieTracker.value = "clear"
                    }
                }
            }
        }
    }

    private suspend fun get(key: Long): Movie? {
        return (withContext(Dispatchers.IO) {
            return@withContext database.get(key)
        })
    }

    private suspend fun update(movie: Movie) {
        withContext(Dispatchers.IO) {
            database.update(movie)
        }
    }

//    fun getMovieName(key: Long) {
//        _currentMovieName.value = database.getMovieName(key) ?: ""
//    }
//
//    fun getMovieRating(key: Long) {
//        _currentMovieRating.value = database.getMovieRating(key) ?: 0
//    }

    fun doneNavigating() {
        _navigateToMovieTracker.value = null
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}