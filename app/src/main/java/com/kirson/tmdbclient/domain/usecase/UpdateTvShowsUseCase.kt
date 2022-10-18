package com.kirson.tmdbclient.domain.usecase

import com.kirson.tmdbclient.data.model.tvshow.TvShow
import com.kirson.tmdbclient.domain.repository.TvShowRepository

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTvShows()


}