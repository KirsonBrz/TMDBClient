package com.kirson.tmdbclient.data.repository.tvshow.datasourceImpl

import com.kirson.tmdbclient.data.db.TvShowDAO
import com.kirson.tmdbclient.data.model.tvshow.TvShow
import com.kirson.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(
    val tvDao: TvShowDAO
) : TvShowLocalDataSource {


    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvDao.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShowList: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvDao.saveTvShows(tvShowList)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvDao.deleteAllTvShows()
        }
    }
}