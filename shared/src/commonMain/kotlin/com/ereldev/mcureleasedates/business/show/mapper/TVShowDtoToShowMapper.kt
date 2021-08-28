package com.ereldev.mcureleasedates.business.show.mapper

import com.ereldev.mcureleasedates.business.common.Mapper
import com.ereldev.mcureleasedates.business.show.model.Show
import com.ereldev.mcureleasedates.business.show.model.TVShowDto

class TVShowDtoToShowMapper: Mapper<TVShowDto, Show>() {

    override fun from(from: TVShowDto) = Show(
        from.name ?: "",
        from.overview ?: ""
    )

}