package com.kirson.tmdbclient.domain.repository

import com.kirson.tmdbclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?

    suspend fun updateMovies() : List<Movie>?



}