package com.ereldev.mcureleasedates.android.list.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ereldev.mcureleasedates.android.R
import com.ereldev.mcureleasedates.android.common.ui.ErrorWithRetry
import com.ereldev.mcureleasedates.android.common.ui.ScreenState
import com.ereldev.mcureleasedates.business.show.factory.ShowFactory
import com.ereldev.mcureleasedates.business.show.model.Show
import com.ereldev.mcureleasedates.business.show.model.Shows

const val LIST_SCREEN_NAME = "list"

@ExperimentalMaterialApi
@Composable
fun ListScreen(
    screenState: MutableState<ScreenState>,
    showsState: MutableState<Shows?>,
    onLoadShowRetry: (() -> Unit)? = null,
    onShowClick: ((show: Show) -> Unit)? = null
) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val screenStatus by remember { screenState }
    val shows by remember { showsState }

    Scaffold {
        when(screenStatus) {
            ScreenState.LOADING -> ListLoading()
            ScreenState.ERROR -> {
                ErrorWithRetry(
                    message = stringResource(id = R.string.unable_to_get_shows_list),
                    modifier = Modifier
                        .fillMaxSize()
                ) { onLoadShowRetry?.let { it() } }
            }
            else -> {
                Column {
                    shows?.let { shows ->
                        when(selectedTabIndex) {
                            ListTab.Movies.ordinal -> { shows.movies }
                            ListTab.TVShows.ordinal -> { shows.tvShows }
                            else -> null
                        }?.let {
                            ShowsList(
                                it,
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxSize()
                            ) { show -> onShowClick?.let { it(show) } }
                        }
                    }

                    Tabs(selectedTabIndex) {
                        selectedTabIndex = it
                    }
                }
            }
        }
    }
}

@Composable
fun Tabs(selectedTabIndex: Int, onTabChange: (Int) -> Unit) {
    val tabTitles = ListTab.values().map { stringResource(it.titleId) }

    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onBackground
    ) {
        tabTitles.forEachIndexed { index, title ->
            Tab(
                selected = (selectedTabIndex == index),
                onClick = { onTabChange(index) }
            ) {
                Text(
                    text = title,
                    modifier = Modifier.padding(15.dp)
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview(showSystemUi = true)
@Composable
fun ListScreenLoadingPreview() {
    val screenState = remember { mutableStateOf(ScreenState.LOADING) }
    val showsState = remember { mutableStateOf<Shows?>(null) }

    ListScreen(
        screenState = screenState,
        showsState = showsState
    )
}

@ExperimentalMaterialApi
@Preview(showSystemUi = true)
@Composable
fun ListScreenErrorPreview() {
    val screenState = remember { mutableStateOf(ScreenState.ERROR) }
    val showsState = remember { mutableStateOf<Shows?>(null) }

    ListScreen(
        screenState = screenState,
        showsState = showsState
    )
}

@ExperimentalMaterialApi
@Preview(showSystemUi = true)
@Composable
fun ListScreenReadyNoShowPreview() {
    val screenState = remember { mutableStateOf(ScreenState.READY) }
    val showsState = remember { mutableStateOf<Shows?>(ShowFactory.emptyShows()) }

    ListScreen(
        screenState = screenState,
        showsState = showsState
    )
}

@ExperimentalMaterialApi
@Preview(showSystemUi = true)
@Composable
fun ListScreenReadyPreview() {
    val screenState = remember { mutableStateOf(ScreenState.READY) }
    val showsState = remember { mutableStateOf<Shows?>(ShowFactory.fixedShows()) }

    ListScreen(
        screenState = screenState,
        showsState = showsState
    )
}