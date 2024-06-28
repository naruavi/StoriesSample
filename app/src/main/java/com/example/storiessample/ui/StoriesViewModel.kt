package com.example.storiessample.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.storiessample.data.ApiService
import com.example.storiessample.data.StoriesRepository
import com.example.storiessample.domain.Story
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class StoriesViewModel: ViewModel() {

    val stories = MutableLiveData<List<Story>>()
    val client = Retrofit.Builder()
        .baseUrl("http://www.omdbapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val storyRepository = StoriesRepository(client.create(ApiService::class.java))

    fun fetchStories() {
        viewModelScope.launch {
            stories.value = storyRepository.fetchStoriesFromServer()
        }
    }
}