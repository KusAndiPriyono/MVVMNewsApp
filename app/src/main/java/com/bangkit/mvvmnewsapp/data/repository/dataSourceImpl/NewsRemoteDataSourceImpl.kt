package com.bangkit.mvvmnewsapp.data.repository.dataSourceImpl

import com.bangkit.mvvmnewsapp.data.api.NewsApiService
import com.bangkit.mvvmnewsapp.data.model.ApiResponse
import com.bangkit.mvvmnewsapp.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsApiService: NewsApiService,
) : NewsRemoteDataSource {
    override suspend fun getTopHeadlines(country: String, page: Int): Response<ApiResponse> {
        return newsApiService.getTopHeadlines(country, page)
    }
}