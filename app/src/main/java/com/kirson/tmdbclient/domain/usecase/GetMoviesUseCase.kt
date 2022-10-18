package com.kirson.tmdbclient.domain.usecase

import com.kirson.tmdbclient.data.model.movie.Movie
import com.kirson.tmdbclient.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {


    suspend fun execute(): List<Movie>? = movieRepository.getMovies()


}