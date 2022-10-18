package com.kirson.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.kirson.tmdbclient.data.model.tvshow.TvShow


@Dao
interface TvShowDAO {

    @Insert(onConflict = REPLACE)
    suspend fun saveTvShows(tvShowList: List<TvShow>)

    @Query("DELETE FROM popular_tvShows")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM popular_tvShows")
    suspend fun getTvShows(): List<TvShow>


}