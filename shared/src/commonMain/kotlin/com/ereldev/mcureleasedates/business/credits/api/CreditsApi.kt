package com.ereldev.mcureleasedates.business.credits.api

import com.ereldev.mcureleasedates.business.common.TheMovieDBApi
import com.ereldev.mcureleasedates.business.credits.model.CreditsDto
import com.ereldev.mcureleasedates.business.show.model.Show
import com.ereldev.mcureleasedates.business.show.model.ShowType
import io.ktor.client.request.*

class CreditsApi: TheMovieDBApi() {

    suspend fun getCredits(show: Show): CreditsDto =
        httpClient.get("$API_URL${getPath(show)}") {
            addQueryParameters(this)
        }

    private fun getPath(show: Show): String {
        val path = when(show.type) {
            ShowType.MOVIE -> MOVIE_CREDIT_PATH
            ShowType.TV -> TV_CREDIT_PATH
        }

        return path.replace("%s", "${show.id}")
    }

    companion object {
        private const val MOVIE_CREDIT_PATH = "/movie/%s/credits"
        private const val TV_CREDIT_PATH = "/tv/%s/credits"
    }

}