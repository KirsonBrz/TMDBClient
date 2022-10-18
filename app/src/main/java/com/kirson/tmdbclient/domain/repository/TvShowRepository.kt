package com.kirson.tmdbclient.domain.repository

import com.kirson.tmdbclient.data.model.tvshow.TvShow

interface TvShowRepository {

    suspend fun getTvShows() : List<TvShow>?
    suspend fun updateTvShows() : List<TvShow>?

}