package com.kirson.tmdbclient.data.repository.artist.datasourceImpl

import com.kirson.tmdbclient.data.api.TMDBService
import com.kirson.tmdbclient.data.model.artist.ArtistList
import com.kirson.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    val tmdbService: TMDBService,
    val apiKey: String
) : ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)
}