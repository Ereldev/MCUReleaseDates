package com.ereldev.mcureleasedates.business.show.mapper

import com.ereldev.mcureleasedates.business.common.DateUtils
import com.ereldev.mcureleasedates.business.show.api.ShowApi
import com.ereldev.mcureleasedates.business.show.model.MovieDto
import com.ereldev.mcureleasedates.business.show.model.ShowType
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class MovieDtoToShowMapperTest {

    private lateinit var mapper: MovieDtoToShowMapper

    @Before
    fun setup() {
        mapper = MovieDtoToShowMapper()
    }

    @Test
    fun testMapDtoToShow() {
        // Arrange
        val dto = MovieDto(
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
        assertEquals(show.type, ShowType.MOVIE)
        assertEquals(show.id, dto.id)
        assertEquals(show.title, dto.title)
        assertEquals(show.overview, dto.overview)
        assertEquals(show.date, DateUtils.formatDate("2021-09-10"))
        assertEquals(show.image, "${ShowApi.POSTER_URL}${dto.posterPath}")
        assertEquals(show.background, "${ShowApi.BACKGROUND_URL}${dto.backdropPath}")
    }

}