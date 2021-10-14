package com.ereldev.mcureleasedates.android.detail.vm

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ereldev.mcureleasedates.android.common.ui.ScreenState
import com.ereldev.mcureleasedates.business.credits.GetCastUseCase
import com.ereldev.mcureleasedates.business.credits.model.Actor
import com.ereldev.mcureleasedates.business.show.model.Show
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch

class DetailViewModel @AssistedInject constructor(
    @Assisted private val show: Show,
    private val getCastUseCase: GetCastUseCase
): ViewModel() {

    var screenState = mutableStateOf(ScreenState.LOADING)
        private set

    var cast = mutableStateOf<List<Actor>?>(null)
        private set

    init {
        loadCast()
    }

    fun loadCast() {
        viewModelScope.launch {
            screenState.value = ScreenState.LOADING

            try {
                getCastUseCase.execute(show).let {
                    cast.value = it
                }

                screenState.value = ScreenState.READY
            } catch (e: Exception) {
                screenState.value = ScreenState.ERROR
            }
        }
    }

}