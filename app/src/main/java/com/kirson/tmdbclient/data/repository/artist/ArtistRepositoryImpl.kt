package com.kirson.tmdbclient.data.repository.artist

import android.util.Log
import com.kirson.tmdbclient.data.model.artist.Artist
import com.kirson.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.kirson.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.kirson.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.kirson.tmdbclient.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource

) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {

        return getArtistsFromCache()

    }

    override suspend fun updateArtists(): List<Artist>? {

        val newListOfArtists = getArtistsFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)

        return newListOfArtists
    }

    suspend fun getArtistsFromApi(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()

            if (body != null) {
                artistList = body.artists
            }

        } catch (ex: Exception) {

            Log.i("MyTag", ex.message.toString())
        }

        return artistList

    }

    suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistLocalDataSource.getArtistsFromDB()

        } catch (ex: Exception) {
            Log.i("MyTag", ex.message.toString())
        }
        if (artistList.size >= 0) {
            return artistList
        } else {
            artistList = getArtistsFromApi()
            artistLocalDataSource.saveArtistsToDB(artistList)

        }

        return artistList
    }

    suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistCacheDataSource.getArtistsFromCache()

        } catch (ex: Exception) {
            Log.i("MyTag", ex.message.toString())
        }
        if (artistList.size >= 0) {
            return artistList
        } else {
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)

        }


        return artistList

    }


}