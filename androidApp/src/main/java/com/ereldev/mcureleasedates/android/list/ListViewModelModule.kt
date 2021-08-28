package com.ereldev.mcureleasedates.android.list

import com.ereldev.mcureleasedates.business.show.GetShowsUseCase
import com.ereldev.mcureleasedates.business.show.api.ShowApi
import com.ereldev.mcureleasedates.business.show.mapper.MovieDtoToShowMapper
import com.ereldev.mcureleasedates.business.show.mapper.TVShowDtoToShowMapper
import com.ereldev.mcureleasedates.business.show.repository.ShowRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ListViewModelModule {

    @Provides
    fun providesShowApi() = ShowApi()

    @Provides
    fun providesMovieDtoToShowMapper() = MovieDtoToShowMapper()

    @Provides
    fun providesTVShowDtoToShowMapper() = TVShowDtoToShowMapper()

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

    @Provides
    fun providesGetShowsUseCase(
        showRepository: ShowRepository
    ) = GetShowsUseCase(
        showRepository
    )

}