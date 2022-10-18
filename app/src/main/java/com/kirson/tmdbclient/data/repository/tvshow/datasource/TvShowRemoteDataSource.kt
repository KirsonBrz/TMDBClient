package com.kirson.tmdbclient.data.repository.tvshow.datasource

import com.kirson.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {

    suspend fun getTvShows(): Response<TvShowList>


}