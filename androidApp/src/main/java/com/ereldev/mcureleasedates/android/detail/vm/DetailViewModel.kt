package com.ereldev.mcureleasedates.android.detail.vm

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    var cast = mutableStateListOf<Actor>()
        private set

    init {
        viewModelScope.launch {
            getCastUseCase.execute(show).let {
                cast.addAll(it)
            }
        }
    }

}