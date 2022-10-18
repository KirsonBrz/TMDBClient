package com.kirson.tmdbclient.presentation.di.core

import com.kirson.tmdbclient.data.db.ArtistDAO
import com.kirson.tmdbclient.data.db.MovieDAO
import com.kirson.tmdbclient.data.db.TvShowDAO
import com.kirson.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.kirson.tmdbclient.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.kirson.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.kirson.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.kirson.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.kirson.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDAO): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvDao: TvShowDAO): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDAO: ArtistDAO): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDAO)
    }


}