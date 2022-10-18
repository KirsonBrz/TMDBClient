package com.kirson.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kirson.tmdbclient.data.model.artist.Artist
import com.kirson.tmdbclient.data.model.movie.Movie
import com.kirson.tmdbclient.data.model.tvshow.TvShow

@Database(
    entities = [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDAO
    abstract fun tvDao(): TvShowDAO
    abstract fun artistDao(): ArtistDAO

}