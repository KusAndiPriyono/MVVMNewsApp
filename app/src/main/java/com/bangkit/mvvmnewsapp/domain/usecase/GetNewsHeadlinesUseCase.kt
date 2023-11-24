package com.bangkit.mvvmnewsapp.domain.usecase

import com.bangkit.mvvmnewsapp.data.model.ApiResponse
import com.bangkit.mvvmnewsapp.data.util.Resource
import com.bangkit.mvvmnewsapp.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country: String, page: Int): Resource<ApiResponse> {
        return newsRepository.getNewsHeadlines(country, page)
    }

}