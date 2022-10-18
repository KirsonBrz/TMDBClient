package com.kirson.tmdbclient.data.repository.tvshow.datasource

import com.kirson.tmdbclient.data.model.tvshow.TvShow

interface TvShowCacheDataSource {

    suspend fun getTvShowsFromCache(): List<TvShow>
    suspend fun saveTvShowsToCache(tvShowList: List<TvShow>)

}