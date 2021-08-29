package com.ereldev.mcureleasedates.business.show.mapper

import com.ereldev.mcureleasedates.business.common.Mapper
import com.ereldev.mcureleasedates.business.show.api.ShowApi
import com.ereldev.mcureleasedates.business.show.model.MovieDto
import com.ereldev.mcureleasedates.business.show.model.Show

class MovieDtoToShowMapper: Mapper<MovieDto, Show>() {

    override fun from(from: MovieDto) = Show(
        from.title ?: "",
        from.overview ?: "",
        from.releaseDate ?: "",
        from.posterPath?.let { "${ShowApi.POSTER_URL}$it" }
    )

}