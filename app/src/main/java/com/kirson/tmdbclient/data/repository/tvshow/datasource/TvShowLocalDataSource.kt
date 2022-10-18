package com.kirson.tmdbclient.data.repository.tvshow.datasource

import com.kirson.tmdbclient.data.model.tvshow.TvShow

interface TvShowLocalDataSource {

    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowsToDB(tvShowList: List<TvShow>)
    suspend fun clearAll()

}