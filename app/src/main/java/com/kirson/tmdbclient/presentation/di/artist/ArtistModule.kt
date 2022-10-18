package com.kirson.tmdbclient.presentation.di.artist

import com.kirson.tmdbclient.domain.usecase.GetArtistsUseCase
import com.kirson.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.kirson.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class ArtistModule {

    @ActivityScoped
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {

        return ArtistViewModelFactory(
            getArtistsUseCase, updateArtistsUseCase
        )
    }

}