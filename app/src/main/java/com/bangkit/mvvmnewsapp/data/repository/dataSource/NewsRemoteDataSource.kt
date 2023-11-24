package com.bangkit.mvvmnewsapp.data.repository.dataSource

import com.bangkit.mvvmnewsapp.data.model.ApiResponse
import retrofit2.Response

interface NewsRemoteDataSource {

    suspend fun getTopHeadlines(country: String, page: Int): Response<ApiResponse>
}