package com.kirson.tmdbclient.presentation.di.core

import android.app.Application
import androidx.room.Room
import com.kirson.tmdbclient.data.db.ArtistDAO
import com.kirson.tmdbclient.data.db.MovieDAO
import com.kirson.tmdbclient.data.db.TMDBDatabase
import com.kirson.tmdbclient.data.db.TvShowDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDataBase(app: Application): TMDBDatabase {
        return Room.databaseBuilder(app.applicationContext, TMDBDatabase::class.java, "tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDAO {
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDAO {
        return tmdbDatabase.artistDao()
    }

    @Singleton
    @Provides
    fun provideTvDao(tmdbDatabase: TMDBDatabase): TvShowDAO {
        return tmdbDatabase.tvDao()
    }


}