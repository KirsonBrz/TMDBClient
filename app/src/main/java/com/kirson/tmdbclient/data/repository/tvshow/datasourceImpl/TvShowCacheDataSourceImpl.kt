package com.kirson.tmdbclient.data.repository.tvshow.datasourceImpl

import com.kirson.tmdbclient.data.model.tvshow.TvShow
import com.kirson.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {

    private var tvShowList = ArrayList<TvShow>()


    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvList: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvList)

    }
}