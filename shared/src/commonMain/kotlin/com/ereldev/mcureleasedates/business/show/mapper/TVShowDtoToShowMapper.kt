package com.ereldev.mcureleasedates.business.show.mapper

import com.ereldev.mcureleasedates.business.common.DateUtils
import com.ereldev.mcureleasedates.business.common.Mapper
import com.ereldev.mcureleasedates.business.show.api.ShowApi
import com.ereldev.mcureleasedates.business.show.model.Show
import com.ereldev.mcureleasedates.business.show.model.TVShowDto

class TVShowDtoToShowMapper: Mapper<TVShowDto, Show>() {

    override fun from(from: TVShowDto) = Show(
        from.name ?: "",
        from.overview ?: "",
        from.firstAirDate?.let { DateUtils.formatDate(it) } ?: "",
        from.posterPath?.let { "${ShowApi.POSTER_URL}$it" }
    )

}