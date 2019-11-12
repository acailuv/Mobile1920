package com.github.acailuv.meeting08_trackmymoviequality

import android.content.res.Resources
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.util.Log
import androidx.core.text.HtmlCompat
import com.github.acailuv.meeting08_trackmymoviequality.database.Movie

fun convertNumericQualityToString(quality: Int, resources: Resources): String {
    var qualityString = "INVALID_RATING"
    when (quality) {
        -1 -> qualityString = "INVALID_RATING"
        1 -> qualityString = resources.getString(R.string.zero_very_bad)
        2 -> qualityString = resources.getString(R.string.one_poor)
        3 -> qualityString = resources.getString(R.string.two_soso)
        4 -> qualityString = resources.getString(R.string.four_pretty_good)
        5 -> qualityString = resources.getString(R.string.five_excellent)
    }
    return qualityString
}

fun convertStringQualityToNumeric(quality: String, resources: Resources): Int {
    var qualityInt = -1
    when (quality) {
        "INVALID_RATING" -> qualityInt = -1
        resources.getString(R.string.zero_very_bad) -> qualityInt = 1
        resources.getString(R.string.one_poor) -> qualityInt = 2
        resources.getString(R.string.two_soso) -> qualityInt = 3
        resources.getString(R.string.four_pretty_good) -> qualityInt = 4
        resources.getString(R.string.five_excellent) -> qualityInt = 5
    }
    return qualityInt
}

fun formatMovies(nights: List<Movie>, resources: Resources): Spanned {
    val sb = StringBuilder()
    sb.apply {
        append(resources.getString(R.string.title))
        nights.forEach {
            append("<br>")
            append(resources.getString(R.string.movie_key))
            append("\t${it.movieId}<br>")
            append(resources.getString(R.string.movie_name))
            append("\t${it.movieName}<br>")
            append(resources.getString(R.string.quality))
            append("\t${convertNumericQualityToString(it.rating, resources)}<br>")
            Log.d("FORMAT_MOVIES", it.movieName + " :: " + it.rating)
        }
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}