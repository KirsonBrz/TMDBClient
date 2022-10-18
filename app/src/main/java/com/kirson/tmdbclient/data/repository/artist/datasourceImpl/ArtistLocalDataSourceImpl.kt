package com.kirson.tmdbclient.data.repository.artist.datasourceImpl

import com.kirson.tmdbclient.data.db.ArtistDAO
import com.kirson.tmdbclient.data.model.artist.Artist
import com.kirson.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(
    val artistDAO: ArtistDAO

) : ArtistLocalDataSource {


    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistDAO.getArtists()
    }

    override suspend fun saveArtistsToDB(artists: List<Artist>) {

        CoroutineScope(Dispatchers.IO).launch {
            artistDAO.saveArtists(artists)
        }

    }

    override suspend fun clearAll() {

        CoroutineScope(Dispatchers.IO).launch {
            artistDAO.deleteArtists()
        }


    }
}