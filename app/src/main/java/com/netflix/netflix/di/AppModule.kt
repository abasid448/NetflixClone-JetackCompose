package com.netflix.netflix.di

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.netflix.netflix.common.ApiConstants
import com.netflix.netflix.data.local.MovieDao
import com.netflix.netflix.data.local.MovieDataBase
import com.netflix.netflix.data.remote.MoviesApi
import com.netflix.netflix.data.repository.MovieRepositoryImpl
import com.netflix.netflix.data.sharedpreference.SharedPreferenceHelper
import com.netflix.netflix.domain.repository.MovieRepository
import com.netflix.netflix.domain.usecase.getmovies.GetPopularMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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

    @Volatile
    private var INSTANCE: MovieDataBase? = null

    private class MovieDatabaseCallback() : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let {
                CoroutineScope(Dispatchers.IO).launch {
                    it.movieDao().insertCategory(ApiConstants.movieCategories)
                }
            }
        }
    }

    @Singleton
    @Provides
    fun provideMovieDataBase(
        @ApplicationContext applicationContext: Context
    ): MovieDataBase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                applicationContext,
                MovieDataBase::class.java,
                "movie_db"
            )
                .addCallback(MovieDatabaseCallback())
                .build()
                .also {
                    INSTANCE = it
                }
            instance
        }
    }

    @Singleton
    @Provides
    fun providesMovieDao(database: MovieDataBase): MovieDao =
        database.movieDao()


    @Provides
    @Singleton
    fun provideSharedPreference(@ApplicationContext applicationContext: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(applicationContext)
    }
    @Provides
    @Singleton
    fun provideSharedpreferenceHelper(sharedPreferences: SharedPreferences): SharedPreferenceHelper =
        SharedPreferenceHelper(sharedPreferences)




    @Provides
    @Singleton
    fun provideMovieRepository(api: MoviesApi, movieDao: MovieDao,sharedPreferenceHelper: SharedPreferenceHelper): MovieRepository {
        return MovieRepositoryImpl(api, movieDao,sharedPreferenceHelper)
    }

    @Provides
    @Singleton
    fun provideGetPopularMoviesUseCase(movieRepository: MovieRepository): GetPopularMoviesUseCase {
        return GetPopularMoviesUseCase(movieRepository)
    }

}