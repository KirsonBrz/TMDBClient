package com.kirson.tmdbclient.data.repository.movie.datasourceImpl

import com.kirson.tmdbclient.data.db.MovieDAO
import com.kirson.tmdbclient.data.model.movie.Movie
import com.kirson.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDAO: MovieDAO) : MovieLocalDataSource {

    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDAO.getMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {

        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.saveMovies(movies)
        }


    }

    override suspend fun clearAll() {

        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.deleteAllMovies()
        }

    }
}