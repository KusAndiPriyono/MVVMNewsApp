package com.bangkit.mvvmnewsapp.presentation.di

import com.bangkit.mvvmnewsapp.data.repository.NewsRepositoryImpl
import com.bangkit.mvvmnewsapp.data.repository.dataSource.NewsRemoteDataSource
import com.bangkit.mvvmnewsapp.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideNewsRepository(newsRemoteDataSource: NewsRemoteDataSource): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource)
    }
}