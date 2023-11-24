package com.bangkit.mvvmnewsapp.presentation.di

import com.bangkit.mvvmnewsapp.data.api.NewsApiService
import com.bangkit.mvvmnewsapp.data.repository.dataSource.NewsRemoteDataSource
import com.bangkit.mvvmnewsapp.data.repository.dataSourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Provides
    @Singleton
    fun provideNewsRemoteDataSource(newsApiService: NewsApiService): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsApiService)
    }
}