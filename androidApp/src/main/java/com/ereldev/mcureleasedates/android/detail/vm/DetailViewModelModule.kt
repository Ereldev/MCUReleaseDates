package com.ereldev.mcureleasedates.android.detail.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ereldev.mcureleasedates.business.show.model.Show
import dagger.Module
import dagger.assisted.AssistedFactory
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DetailViewModelModule {

    @AssistedFactory
    interface Factory {
        fun create(show: Show): DetailViewModel
    }

    companion object {

        fun provideFactory(
            assistedFactory: Factory,
            show: Show,
        ) : ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return assistedFactory.create(show) as T
            }
        }

    }

}