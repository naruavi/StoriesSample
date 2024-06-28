package com.example.storiessample.domain

data class StoryResponse(
    val Search: List<Story>,
    val TotalResults: String,
    val Response: Boolean
)