package com.ereldev.mcureleasedates.android.list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ereldev.mcureleasedates.business.show.GetShowsUseCase
import com.ereldev.mcureleasedates.business.show.model.Show
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ListViewModel: ViewModel() {

    var loading = mutableStateOf(true)
        private set

    var movies = listOf<Show>()
        private set
    var tvShows = listOf<Show>()
        private set

    // TODO use injection
    private val getShowsUseCase = GetShowsUseCase()

    init {
        viewModelScope.launch {
            delay(2000)

            val shows = getShowsUseCase.execute()
            movies = shows.movies
            tvShows = shows.tvShows

            loading.value = false
        }
    }

}