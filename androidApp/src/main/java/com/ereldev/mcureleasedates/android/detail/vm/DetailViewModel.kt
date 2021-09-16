package com.ereldev.mcureleasedates.android.detail.vm

import androidx.lifecycle.ViewModel
import com.ereldev.mcureleasedates.business.show.model.Show
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

class DetailViewModel @AssistedInject constructor(
    @Assisted private val show: Show
): ViewModel() {

    init {

    }

}