package com.bangkit.mvvmnewsapp.domain.usecase

import com.bangkit.mvvmnewsapp.data.model.Article
import com.bangkit.mvvmnewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {

    fun execute(): Flow<List<Article>> {
        return newsRepository.getSavedNews()
    }
}