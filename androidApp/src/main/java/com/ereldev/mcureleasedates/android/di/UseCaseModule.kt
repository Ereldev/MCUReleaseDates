package com.ereldev.mcureleasedates.android.di

import com.ereldev.mcureleasedates.business.credits.GetCastUseCase
import com.ereldev.mcureleasedates.business.credits.repository.CreditsRepository
import com.ereldev.mcureleasedates.business.show.GetShowsUseCase
import com.ereldev.mcureleasedates.business.show.repository.ShowRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun providesGetShowsUseCase(
        showRepository: ShowRepository
    ) = GetShowsUseCase(
        showRepository
    )

    @Singleton
    @Provides
    fun providesGetCastUseCase(
        creditsRepository: CreditsRepository
    ) = GetCastUseCase(
        creditsRepository
    )

}