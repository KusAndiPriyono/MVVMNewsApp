package com.bangkit.mvvmnewsapp.domain.usecase

import com.bangkit.mvvmnewsapp.data.model.Article
import com.bangkit.mvvmnewsapp.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article) = newsRepository.saveNews(article)
}