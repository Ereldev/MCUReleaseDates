package com.ereldev.mcureleasedates.android.common.ui

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ereldev.mcureleasedates.android.detail.ui.DETAIL_SCREEN_ARG_SHOW
import com.ereldev.mcureleasedates.android.detail.ui.DETAIL_SCREEN_NAME
import com.ereldev.mcureleasedates.android.detail.ui.DetailScreen
import com.ereldev.mcureleasedates.android.detail.ui.detailViewModelProvider
import com.ereldev.mcureleasedates.android.list.ui.LIST_SCREEN_NAME
import com.ereldev.mcureleasedates.android.list.ui.ListScreen
import com.ereldev.mcureleasedates.business.show.model.Show

@ExperimentalMaterialApi
@Composable
fun MCUReleaseDatesNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = LIST_SCREEN_NAME) {
        composable(LIST_SCREEN_NAME) {
            ListScreen(hiltViewModel(), navController)
        }
        composable(DETAIL_SCREEN_NAME) {
            navController.previousBackStackEntry?.arguments?.getParcelable<Show>(
                DETAIL_SCREEN_ARG_SHOW
            )?.let {
                DetailScreen(it, detailViewModelProvider(it))
            }
        }
    }
}