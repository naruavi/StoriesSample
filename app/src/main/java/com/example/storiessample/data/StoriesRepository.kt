package com.example.storiessample.data

import com.example.storiessample.domain.Story

class StoriesRepository(private val service: ApiService) {
    suspend fun fetchStoriesFromServer(): List<Story> {
        return service.fetchStories().Search
    }
}