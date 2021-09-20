package com.ereldev.mcureleasedates.android.di

import com.ereldev.mcureleasedates.business.show.api.ShowApi
import com.ereldev.mcureleasedates.business.show.mapper.MovieDtoToShowMapper
import com.ereldev.mcureleasedates.business.show.mapper.TVShowDtoToShowMapper
import com.ereldev.mcureleasedates.business.show.repository.ShowRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providesShowApi() = ShowApi()

    @Singleton
    @Provides
    fun providesMovieDtoToShowMapper() = MovieDtoToShowMapper()

    @Singleton
    @Provides
    fun providesTVShowDtoToShowMapper() = TVShowDtoToShowMapper()

    @Singleton
    @Provides
    fun providesShowRepository(
        showApi: ShowApi,
        movieMapper: MovieDtoToShowMapper,
        tvShowMapper: TVShowDtoToShowMapper
    ) = ShowRepository(
        showApi,
        movieMapper,
        tvShowMapper
    )

}