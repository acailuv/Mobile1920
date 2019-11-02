package com.github.acailuv.meeting08_trackmymoviequality.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [Movie::class], version = 1, exportSchema = false)
abstract class MovieDatabase: RoomDatabase() {
    abstract val movieDatabaseDao: MovieDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: MovieDatabase? = null

        fun getInstance(context: Context): MovieDatabase {
            synchronized(this) {
                var instance = INSTANCE;
                if (instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext,
                        MovieDatabase::class.java,
                        "movie_rating_database").fallbackToDestructiveMigration().build()
                }
                return instance
            }
        }
    }

}