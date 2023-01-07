package com.example.mytestwork.api.dailymotion

import com.example.mytestwork.db.UserEntity

data class User(
    val id: String,
    val screenname: String
){
    fun mapTo() = UserEntity(id = id, userName = screenname, image = "", api = "https://api.dailymotion.com")
}