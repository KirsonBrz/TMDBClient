package com.kirson.tmdbclient.data.repository.movie.datasource

import com.kirson.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies(): Response<MovieList>

}