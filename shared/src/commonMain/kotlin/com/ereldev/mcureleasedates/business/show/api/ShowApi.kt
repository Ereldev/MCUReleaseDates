package com.ereldev.mcureleasedates.business.show.api

import com.ereldev.mcureleasedates.BuildKonfig
import com.ereldev.mcureleasedates.business.common.HttpClientFactory
import com.ereldev.mcureleasedates.business.common.ResponseDto
import com.ereldev.mcureleasedates.business.show.model.MovieDto
import com.ereldev.mcureleasedates.business.show.model.TVShowDto
import io.ktor.client.*
import io.ktor.client.request.*

class ShowApi {

    private val httpClient: HttpClient = HttpClientFactory.buildClient()

    // TODO Handle phone language
    suspend fun getMovies(): ResponseDto<List<MovieDto>> =
        httpClient.get("$API_URL$DISCOVER_MOVIE_PATH") {
            addQueryParameters(this)
            parameter("release_date.gte", "2021-08-27") //TODO set date to method params
        }

    suspend fun getTVShows(): ResponseDto<List<TVShowDto>> =
        httpClient.get("$API_URL$DISCOVER_TV_PATH") {
            addQueryParameters(this)
            parameter("air_date.gte", "2021-08-27") //TODO set date to method params
        }

    private fun addQueryParameters(query: HttpRequestBuilder) =
        query.apply {
            parameter("api_key", BuildKonfig.themoviedbApiKey)
            parameter("with_keywords", KEYWORD_MCU)
        }

    companion object {
        private const val API_URL = "https://api.themoviedb.org/3"

        const val POSTER_URL = "https://image.tmdb.org/t/p/w154"

        private const val DISCOVER_MOVIE_PATH = "/discover/movie"
        private const val DISCOVER_TV_PATH = "/discover/tv"

        private const val KEYWORD_MCU = "180547"
    }

}