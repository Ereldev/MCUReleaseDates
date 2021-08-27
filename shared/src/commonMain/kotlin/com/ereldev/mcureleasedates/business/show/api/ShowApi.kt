package com.ereldev.mcureleasedates.business.show.api

import com.ereldev.mcureleasedates.business.common.HttpClientFactory
import com.ereldev.mcureleasedates.business.common.ResponseDto
import com.ereldev.mcureleasedates.business.show.model.Show
import com.ereldev.mcureleasedates.business.show.model.ShowDto
import io.ktor.client.*
import io.ktor.client.request.*

class ShowApi {

    private val httpClient: HttpClient = HttpClientFactory.buildClient()

    // TODO move api key local config file
    suspend fun getMovies(): ResponseDto<List<ShowDto>> =
        httpClient.get("https://api.themoviedb.org/3/discover/movie?release_date.gte=2021-08-27&api_key=<TODO>&with_keywords=180547")

    suspend fun getTVShows(): List<Show> {
        return listOf(Show("What If?"))
    }

}