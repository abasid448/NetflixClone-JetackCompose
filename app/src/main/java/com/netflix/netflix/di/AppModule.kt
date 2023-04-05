package com.netflix.netflix.di

import com.netflix.netflix.common.ApiConstants
import com.netflix.netflix.data.remote.MoviesApi
import com.netflix.netflix.data.repository.MovieRepositoryImpl
import com.netflix.netflix.domain.repository.MovieRepository
import com.netflix.netflix.domain.usecase.getmovies.GetPopularMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieApi(): MoviesApi {
        return Retrofit.Builder().baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MoviesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api: MoviesApi): MovieRepository {
        return MovieRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetPopularMoviesUseCase(movieRepository: MovieRepository): GetPopularMoviesUseCase {
        return GetPopularMoviesUseCase(movieRepository)
    }

}