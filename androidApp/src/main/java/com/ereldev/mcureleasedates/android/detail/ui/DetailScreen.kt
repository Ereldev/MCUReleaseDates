package com.ereldev.mcureleasedates.android.detail.ui

import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ereldev.mcureleasedates.android.MainActivity
import com.ereldev.mcureleasedates.android.R
import com.ereldev.mcureleasedates.android.common.ui.*
import com.ereldev.mcureleasedates.android.detail.vm.DetailViewModel
import com.ereldev.mcureleasedates.android.detail.vm.DetailViewModelModule
import com.ereldev.mcureleasedates.business.credits.factory.CreditsFactory
import com.ereldev.mcureleasedates.business.credits.model.Actor
import com.ereldev.mcureleasedates.business.show.factory.ShowFactory
import com.ereldev.mcureleasedates.business.show.model.Show
import dagger.hilt.android.EntryPointAccessors

const val DETAIL_SCREEN_ARG_SHOW = "show"
const val DETAIL_SCREEN_NAME = "detail/{$DETAIL_SCREEN_ARG_SHOW}"

@Composable
fun DetailScreen(
    show: Show,
    screenState: MutableState<ScreenState>,
    castState: MutableState<List<Actor>?>,
    onLoadCastRetry: (() -> Unit)? = null,
) {
    val screenStatus by remember { screenState }
    val cast by remember { castState }
    val scrollState = rememberScrollState()

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

        Text(
            text = stringResource(R.string.release_date, show.date),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )

        Column(
            Modifier
                .verticalScroll(scrollState)
        ) {
            Title2(text = stringResource(R.string.synopsis))
            Text(text = show.overview, modifier = Modifier.padding(8.dp))

            Title2(text = stringResource(R.string.cast))

            when(screenStatus) {
                ScreenState.LOADING -> {
                    CastList(
                        modifier = Modifier
                            .height(200.dp)
                    )
                }
                ScreenState.ERROR -> {
                    ErrorWithRetry(
                        message = stringResource(id = R.string.unable_to_get_cast),
                        modifier = Modifier
                            .fillMaxSize()
                    ) { onLoadCastRetry?.let { it() } }
                }
                else -> {
                    CastList(
                        cast = cast,
                        modifier = Modifier
                            .height(200.dp)
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DetailScreenLoadingPreview() {
    ShowFactory.fixedShows().movies.first().let {
        val screenState = remember { mutableStateOf(ScreenState.LOADING) }
        val castState = remember { mutableStateOf<List<Actor>?>(null) }

        DetailScreen(
            show = it,
            screenState = screenState,
            castState = castState
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun DetailScreenErrorPreview() {
    ShowFactory.fixedShows().movies.first().let {
        val screenState = remember { mutableStateOf(ScreenState.ERROR) }
        val castState = remember { mutableStateOf<List<Actor>?>(null) }

        DetailScreen(
            show = it,
            screenState = screenState,
            castState = castState
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun DetailScreenReadyPreview() {
    ShowFactory.fixedShows().movies.first().let {
        val screenState = remember { mutableStateOf(ScreenState.READY) }
        val castState = remember { mutableStateOf<List<Actor>?>(CreditsFactory.fixedCredits().cast) }

        DetailScreen(
            show = it,
            screenState = screenState,
            castState = castState
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