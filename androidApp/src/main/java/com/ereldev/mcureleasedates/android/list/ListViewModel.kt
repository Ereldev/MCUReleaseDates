package com.ereldev.mcureleasedates.android.list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ereldev.mcureleasedates.android.common.ui.ScreenState
import com.ereldev.mcureleasedates.business.show.GetShowsUseCase
import com.ereldev.mcureleasedates.business.show.model.Show
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getShowsUseCase: GetShowsUseCase
): ViewModel() {

    var screenState = mutableStateOf(ScreenState.LOADING)
        private set

    var movies = listOf<Show>()
        private set
    var tvShows = listOf<Show>()
        private set

    init {
        loadShows()
    }

    fun loadShows() {
        viewModelScope.launch {
            screenState.value = ScreenState.LOADING

            try {
                getShowsUseCase.execute().let {
                    movies = it.movies
                    tvShows = it.tvShows
                }

                screenState.value = ScreenState.READY
            } catch (e: Exception) {
                screenState.value = ScreenState.ERROR
            }
        }
    }

}