package com.bangkit.mvvmnewsapp.domain.usecase

import com.bangkit.mvvmnewsapp.data.model.ApiResponse
import com.bangkit.mvvmnewsapp.data.util.Resource
import com.bangkit.mvvmnewsapp.domain.repository.NewsRepository

class GetSearchNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(searchQuery: String): Resource<ApiResponse> {
        return newsRepository.getSearchNews(searchQuery)
    }
}