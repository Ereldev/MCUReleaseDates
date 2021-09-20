package com.ereldev.mcureleasedates.android.detail.ui

import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ereldev.mcureleasedates.android.MainActivity
import com.ereldev.mcureleasedates.android.common.ui.PosterImage
import com.ereldev.mcureleasedates.android.common.ui.ShowImage
import com.ereldev.mcureleasedates.android.common.ui.Title1
import com.ereldev.mcureleasedates.android.common.ui.Title2
import com.ereldev.mcureleasedates.android.detail.vm.DetailViewModel
import com.ereldev.mcureleasedates.android.detail.vm.DetailViewModelModule
import com.ereldev.mcureleasedates.business.show.factory.ShowFactory
import com.ereldev.mcureleasedates.business.show.model.Show
import dagger.hilt.android.EntryPointAccessors

const val DETAIL_SCREEN_ARG_SHOW = "show"
const val DETAIL_SCREEN_NAME = "detail/{$DETAIL_SCREEN_ARG_SHOW}"

@Composable
fun DetailScreen(
    show: Show,
    detailViewModel: DetailViewModel
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            ShowImage(
                url = show.background,
                description = show.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Box(modifier = Modifier.padding(start = 10.dp, top = 10.dp)) {
                PosterImage(
                    url = show.image,
                    description = show.title,
                    modifier = Modifier
                        .width(87.dp)
                        .height(125.dp)
                )
            }
        }
        Title1(text = show.title)
        Text(text = "Release date: TODO")
        Spacer(modifier = Modifier.height(8.dp))
        Title2(text = "Synopsis")
        Text(text = show.overview)
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    ShowFactory.fixedShows().movies.first().let {
        DetailScreen(
            it,
            detailViewModelProvider(it)
        )
    }
}

@Composable
fun detailViewModelProvider(show: Show): DetailViewModel {
    val factory = EntryPointAccessors.fromActivity(
        LocalContext.current as Activity,
        MainActivity.ViewModelFactoryProvider::class.java
    ).detailViewModelFactory()

    return viewModel(factory = DetailViewModelModule.provideFactory(factory, show))
}