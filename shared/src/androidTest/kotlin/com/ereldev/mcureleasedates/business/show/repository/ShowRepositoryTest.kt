package com.ereldev.mcureleasedates.business.show.repository

import com.ereldev.mcureleasedates.business.common.ResponseDto
import com.ereldev.mcureleasedates.business.show.api.ShowApi
import com.ereldev.mcureleasedates.business.show.mapper.MovieDtoToShowMapper
import com.ereldev.mcureleasedates.business.show.mapper.TVShowDtoToShowMapper
import com.ereldev.mcureleasedates.business.show.model.MovieDto
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Before
import org.junit.Test

class ShowRepositoryTest {

    private lateinit var repository: ShowRepository

    private val apiMock = mockk<ShowApi>()
    private val movieMapperMock = mockk<MovieDtoToShowMapper>()
    private val tvShowMapperMock = mockk<TVShowDtoToShowMapper>()

    @Before
    fun setup() {
        repository = ShowRepository(
            apiMock,
            movieMapperMock,
            tvShowMapperMock
        )
    }

    @Test
    fun testGetMovies() {
        // Arrange

        coEvery { apiMock.getMovies() } returns ResponseDto(listOf(), 1, 1, 1)

        // Act

        // Assert

    }

    @Test
    fun testGetTVShow() {

    }

}