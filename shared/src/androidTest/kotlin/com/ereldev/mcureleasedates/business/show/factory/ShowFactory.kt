package com.ereldev.mcureleasedates.business.show.factory

import com.ereldev.mcureleasedates.business.show.model.MovieDto
import com.ereldev.mcureleasedates.business.show.model.Show
import com.ereldev.mcureleasedates.business.show.model.ShowType
import com.ereldev.mcureleasedates.business.show.model.TVShowDto

object ShowFactory {

    fun getMoviesDto() = listOf(
        MovieDto(1, "title 1", "overview 1", "poster.jpg", "background.jpg", "2021-09-10"),
        MovieDto(2, "title 2", "overview 2", "poster.jpg", "background.jpg", "2021-09-10")
    )

    fun getMovies() = listOf(
        Show(ShowType.MOVIE,1, "title 1", "overview 1", "2021-09-10", "2021-09-10", "poster.jpg", "background.jpg"),
        Show(ShowType.MOVIE, 2, "title 2", "overview 2", "2021-09-10", "2021-09-10", "poster.jpg", "background.jpg")
    )

    fun getTVShowsDto() = listOf(
        TVShowDto(1, "title 1", "overview 1", "poster.jpg", "background.jpg", "2021-09-10"),
        TVShowDto(2, "title 2", "overview 2", "poster.jpg", "background.jpg", "2021-09-10")
    )

    fun getTVShows() = listOf(
        Show(ShowType.TV,1, "title 1", "overview 1", "2021-09-10", "2021-09-10", "poster.jpg", "background.jpg"),
        Show(ShowType.TV, 2, "title 2", "overview 2", "2021-09-10", "2021-09-10", "poster.jpg", "background.jpg")
    )

}