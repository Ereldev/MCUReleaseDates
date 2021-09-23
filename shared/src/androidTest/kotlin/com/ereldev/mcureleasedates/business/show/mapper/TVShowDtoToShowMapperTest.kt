package com.ereldev.mcureleasedates.business.show.mapper

import com.ereldev.mcureleasedates.business.common.DateUtils
import com.ereldev.mcureleasedates.business.show.api.ShowApi
import com.ereldev.mcureleasedates.business.show.model.ShowType
import com.ereldev.mcureleasedates.business.show.model.TVShowDto
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TVShowDtoToShowMapperTest {

    private lateinit var mapper: TVShowDtoToShowMapper

    @BeforeTest
    fun setup() {
        mapper = TVShowDtoToShowMapper()
    }

    @Test
    fun testMapDtoToShow() {
        // Arrange
        val dto = TVShowDto(
            45,
            "test movie",
            "movie overview",
            "/url.poster.jpg",
            "/url/backdrop.jpg",
            "2021-09-10"
        )

        // Act
        val show = mapper.from(dto)

        // Assert
        assertEquals(show.type, ShowType.TV)
        assertEquals(show.id, dto.id)
        assertEquals(show.title, dto.name)
        assertEquals(show.overview, dto.overview)
        assertEquals(show.date, DateUtils.formatDate("2021-09-10"))
        assertEquals(show.image, "${ShowApi.POSTER_URL}${dto.posterPath}")
        assertEquals(show.background, "${ShowApi.BACKGROUND_URL}${dto.backdropPath}")
    }

}