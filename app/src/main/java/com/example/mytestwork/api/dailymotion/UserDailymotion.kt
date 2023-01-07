package com.example.mytestwork.api.dailymotion

data class UserDailymotion(
    val explicit: Boolean,
    val has_more: Boolean,
    val limit: Int,
    val list: List<User>,
    val page: Int,
    val total: Int
)