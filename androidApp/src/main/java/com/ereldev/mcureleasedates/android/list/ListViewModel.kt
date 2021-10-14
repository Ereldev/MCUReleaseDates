package com.ereldev.mcureleasedates.android.list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ereldev.mcureleasedates.android.common.ui.ScreenState
import com.ereldev.mcureleasedates.business.show.GetShowsUseCase
import com.ereldev.mcureleasedates.business.show.model.Shows
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getShowsUseCase: GetShowsUseCase
): ViewModel() {

    var screenState = mutableStateOf(ScreenState.LOADING)
        private set

    var shows = mutableStateOf<Shows?>(null)
        private set

    init {
        loadShows()
    }

    fun loadShows() {
        viewModelScope.launch {
            screenState.value = ScreenState.LOADING

            try {
                getShowsUseCase.execute().let {
                    shows.value = it
                }

                screenState.value = ScreenState.READY
            } catch (e: Exception) {
                screenState.value = ScreenState.ERROR
            }
        }
    }

}