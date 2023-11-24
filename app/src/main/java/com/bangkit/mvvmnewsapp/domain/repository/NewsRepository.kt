package com.bangkit.mvvmnewsapp.domain.repository

import com.bangkit.mvvmnewsapp.data.model.ApiResponse
import com.bangkit.mvvmnewsapp.data.model.Article
import com.bangkit.mvvmnewsapp.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getNewsHeadlines(country: String, page: Int): Resource<ApiResponse>
    suspend fun getSearchNews(searchQuery: String): Resource<ApiResponse>
    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>
}