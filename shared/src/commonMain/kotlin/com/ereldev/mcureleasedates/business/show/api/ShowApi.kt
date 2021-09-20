package com.ereldev.mcureleasedates.business.show.api

import com.ereldev.mcureleasedates.business.common.*
import com.ereldev.mcureleasedates.business.show.model.MovieDto
import com.ereldev.mcureleasedates.business.show.model.TVShowDto
import io.ktor.client.request.*

class ShowApi: TheMovieDBApi() {

    suspend fun getMovies(): ResponseDto<List<MovieDto>> =
        httpClient.get("$API_URL$DISCOVER_MOVIE_PATH") {
            addQueryParameters(this)
            parameter("with_keywords", KEYWORD_MCU)
            parameter("sort_by", "release_date.asc")
            parameter("release_date.gte", DateUtils.nowMinusOneMonth())
        }

    suspend fun getTVShows(): ResponseDto<List<TVShowDto>> =
        httpClient.get("$API_URL$DISCOVER_TV_PATH") {
            addQueryParameters(this)
            parameter("with_keywords", KEYWORD_MCU)
            parameter("sort_by", "first_air_date.asc")
            parameter("air_date.gte", DateUtils.nowMinusOneMonth())
        }

    companion object {
        const val POSTER_URL = "https://image.tmdb.org/t/p/w154"
        const val BACKGROUND_URL = "https://image.tmdb.org/t/p/w500"

        private const val DISCOVER_MOVIE_PATH = "/discover/movie"
        private const val DISCOVER_TV_PATH = "/discover/tv"

        private const val KEYWORD_MCU = "180547"
    }

}