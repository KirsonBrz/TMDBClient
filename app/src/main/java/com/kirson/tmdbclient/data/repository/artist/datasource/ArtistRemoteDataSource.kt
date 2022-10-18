package com.kirson.tmdbclient.data.repository.artist.datasource

import com.kirson.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {

    suspend fun getArtists(): Response<ArtistList>

}