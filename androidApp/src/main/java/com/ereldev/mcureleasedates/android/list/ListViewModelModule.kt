package com.ereldev.mcureleasedates.android.list

import com.ereldev.mcureleasedates.business.show.GetShowsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ListViewModelModule {

    @Provides
    fun providesGetShowsUseCase() = GetShowsUseCase()

}