package com.ereldev.mcureleasedates.business.show.repository

import com.ereldev.mcureleasedates.business.common.ResponseDto
import com.ereldev.mcureleasedates.business.show.api.ShowApi
import com.ereldev.mcureleasedates.business.show.factory.ShowFactory
import com.ereldev.mcureleasedates.business.show.mapper.MovieDtoToShowMapper
import com.ereldev.mcureleasedates.business.show.mapper.TVShowDtoToShowMapper
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

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
    fun testGetMovies() = runBlocking {
        // Arrange
        val moviesDto = ShowFactory.getMoviesDto()
        val movies = ShowFactory.getMovies()

        coEvery { apiMock.getMovies(ShowApi.KEYWORD_MARVEL_COMICS) } returns ResponseDto(moviesDto, 1, 1, 1)
        every { movieMapperMock.from(moviesDto[0]) } returns movies[0]
        every { movieMapperMock.from(moviesDto[1]) } returns movies[1]

        // Act
        val result = repository.getMovies(ShowApi.KEYWORD_MARVEL_COMICS)

        // Assert
        assertEquals(result, movies)
        coVerify { apiMock.getMovies(ShowApi.KEYWORD_MARVEL_COMICS) }
        verify { movieMapperMock.from(moviesDto[0]) }
        verify { movieMapperMock.from(moviesDto[1]) }
    }

    @Test
    fun testGetTVShow() = runBlocking {
        // Arrange
        val tvShowsDto = ShowFactory.getTVShowsDto()
        val tvShows = ShowFactory.getTVShows()

        coEvery { apiMock.getTVShows(ShowApi.KEYWORD_MARVEL_COMICS) } returns ResponseDto(tvShowsDto, 1, 1, 1)
        every { tvShowMapperMock.from(tvShowsDto[0]) } returns tvShows[0]
        every { tvShowMapperMock.from(tvShowsDto[1]) } returns tvShows[1]

        // Act
        val result = repository.getTVShows(ShowApi.KEYWORD_MARVEL_COMICS)

        // Assert
        assertEquals(result, tvShows)
        coVerify { apiMock.getTVShows(ShowApi.KEYWORD_MARVEL_COMICS) }
        verify { tvShowMapperMock.from(tvShowsDto[0]) }
        verify { tvShowMapperMock.from(tvShowsDto[1]) }
    }

}