package com.kirson.tmdbclient.presentation.di.core

import com.kirson.tmdbclient.BuildConfig
import com.kirson.tmdbclient.data.api.TMDBService
import com.kirson.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.kirson.tmdbclient.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.kirson.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.kirson.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.kirson.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.kirson.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule() {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(
            tmdbService, BuildConfig.API_KEY
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(
            tmdbService, BuildConfig.API_KEY
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(
            tmdbService, BuildConfig.API_KEY
        )
    }


}