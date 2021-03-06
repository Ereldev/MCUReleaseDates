package com.ereldev.mcureleasedates.business.show.mapper

import com.ereldev.mcureleasedates.business.common.DateUtils
import com.ereldev.mcureleasedates.business.common.Mapper
import com.ereldev.mcureleasedates.business.show.api.ShowApi
import com.ereldev.mcureleasedates.business.show.model.MovieDto
import com.ereldev.mcureleasedates.business.show.model.Show
import com.ereldev.mcureleasedates.business.show.model.ShowType

class MovieDtoToShowMapper: Mapper<MovieDto, Show>() {

    override fun from(from: MovieDto) = Show(
        ShowType.MOVIE,
        from.id,
        from.title ?: "",
        from.overview ?: "",
        from.releaseDate ?:"",
        from.releaseDate?.let { DateUtils.formatDate(it) } ?: "",
        from.posterPath?.let { "${ShowApi.POSTER_URL}$it" },
        from.backdropPath?.let { "${ShowApi.BACKGROUND_URL}$it" }
    )

}