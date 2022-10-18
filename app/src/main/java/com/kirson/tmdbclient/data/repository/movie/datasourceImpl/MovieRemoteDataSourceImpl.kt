package com.kirson.tmdbclient.data.repository.movie.datasourceImpl

import com.kirson.tmdbclient.data.api.TMDBService
import com.kirson.tmdbclient.data.model.movie.MovieList
import com.kirson.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDataSource {


    override suspend fun getMovies(): Response<MovieList> =
        tmdbService.getPopularMovies(apiKey)


}