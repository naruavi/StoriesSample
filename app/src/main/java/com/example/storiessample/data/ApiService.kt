package com.example.storiessample.data

import com.example.storiessample.domain.StoryResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/")
    suspend fun fetchStories(@Query("s") s: String="mar", @Query("apiKey")a: String="2fa2a162", @Query("page")p: Int = 1): StoryResponse
}