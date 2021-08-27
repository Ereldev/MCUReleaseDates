package com.ereldev.mcureleasedates.android.list

import com.ereldev.mcureleasedates.business.show.GetShowsUseCase
import com.ereldev.mcureleasedates.business.show.api.ShowApi
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
    fun providesShowRepository(
        showApi: ShowApi
    ) = ShowRepository(
        showApi
    )

    @Provides
    fun providesGetShowsUseCase(
        showRepository: ShowRepository
    ) = GetShowsUseCase(
        showRepository
    )

}