package com.ereldev.mcureleasedates.android.detail.ui

import android.app.Activity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ereldev.mcureleasedates.android.MainActivity
import com.ereldev.mcureleasedates.android.detail.vm.DetailViewModel
import com.ereldev.mcureleasedates.android.detail.vm.DetailViewModelModule
import com.ereldev.mcureleasedates.business.show.model.Show
import dagger.hilt.android.EntryPointAccessors

const val DETAIL_SCREEN_ARG_SHOW = "show"
const val DETAIL_SCREEN_NAME = "detail/{$DETAIL_SCREEN_ARG_SHOW}"

@Composable
fun DetailScreen(
    show: Show,
    detailViewModel: DetailViewModel
) {
    Text(text = show.title)
}

@Composable
fun detailViewModelProvider(show: Show): DetailViewModel {
    val factory = EntryPointAccessors.fromActivity(
        LocalContext.current as Activity,
        MainActivity.ViewModelFactoryProvider::class.java
    ).detailViewModelFactory()

    return viewModel(factory = DetailViewModelModule.provideFactory(factory, show))
}