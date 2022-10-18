package com.kirson.tmdbclient.domain.usecase

import com.kirson.tmdbclient.data.model.artist.Artist
import com.kirson.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()
}