package com.kirson.tmdbclient.data.repository.tvshow

import android.util.Log
import com.kirson.tmdbclient.data.model.tvshow.TvShow
import com.kirson.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.kirson.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.kirson.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.kirson.tmdbclient.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource

) : TvShowRepository {


    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newTvShowList = getTvShowsFromApi()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newTvShowList)
        tvShowCacheDataSource.saveTvShowsToCache(newTvShowList)

        return newTvShowList

    }


    suspend fun getTvShowsFromApi(): List<TvShow> {

        lateinit var tvShowList: List<TvShow>

        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if (body != null) {
                tvShowList = body.tvShows
            }

        } catch (ex: Exception) {
            Log.i("MyTag", ex.message.toString())
        }

        return tvShowList
    }

    suspend fun getTvShowsFromDB(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()
        } catch (ex: Exception) {
            Log.i("MyTag", ex.message.toString())
        }

        if (tvShowList.size >= 0) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromApi()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }

        return tvShowList
    }

    suspend fun getTvShowsFromCache(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()
        } catch (ex: Exception) {
            Log.i("MyTag", ex.message.toString())
        }

        if (tvShowList.size >= 0) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        }

        return tvShowList
    }


}