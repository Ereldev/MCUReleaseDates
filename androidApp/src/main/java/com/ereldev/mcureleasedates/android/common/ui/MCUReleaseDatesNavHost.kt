package com.ereldev.mcureleasedates.android.common.ui

import android.os.Bundle
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ereldev.mcureleasedates.android.detail.ui.DETAIL_SCREEN_ARG_SHOW
import com.ereldev.mcureleasedates.android.detail.ui.DETAIL_SCREEN_NAME
import com.ereldev.mcureleasedates.android.detail.ui.DetailScreen
import com.ereldev.mcureleasedates.android.detail.ui.detailViewModelProvider
import com.ereldev.mcureleasedates.android.list.ListViewModel
import com.ereldev.mcureleasedates.android.list.ui.LIST_SCREEN_NAME
import com.ereldev.mcureleasedates.android.list.ui.ListScreen
import com.ereldev.mcureleasedates.business.show.model.Show

@ExperimentalMaterialApi
@Composable
fun MCUReleaseDatesNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = LIST_SCREEN_NAME) {
        composable(LIST_SCREEN_NAME) {
            CreateListScreen(navController)
        }
        composable(DETAIL_SCREEN_NAME) {
            CreateDetailScreen(navController)
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun CreateListScreen(navController: NavHostController) {
    val viewModel: ListViewModel = hiltViewModel()

    ListScreen(
        screenState = viewModel.screenState,
        showsState = viewModel.shows,
        onLoadShowRetry = { viewModel.loadShows() },
        onShowClick = { onShowClick(navController, it) }
    )
}

@Composable
fun CreateDetailScreen(navController: NavHostController) {
    navController.previousBackStackEntry?.arguments?.getParcelable<Show>(
        DETAIL_SCREEN_ARG_SHOW
    )?.let {
        val viewModel = detailViewModelProvider(it)

        DetailScreen(
            show = it,
            screenState = viewModel.screenState,
            castState = viewModel.cast,
            onLoadCastRetry = { viewModel.loadCast() }
        )
    }
}

private fun onShowClick(navController: NavController, show: Show) {
    navController.currentBackStackEntry?.arguments = Bundle().apply {
        putParcelable(DETAIL_SCREEN_ARG_SHOW, show)
    }
    navController.navigate(DETAIL_SCREEN_NAME)
}
