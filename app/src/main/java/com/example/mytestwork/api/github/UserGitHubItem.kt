package com.example.mytestwork.api.github

import com.example.mytestwork.db.UserEntity

data class UserGitHubItem(
    val avatar_url: String,
    val events_url: String,
    val followers_url: String,
    val following_url: String,
    val gists_url: String,
    val gravatar_id: String,
    val html_url: String,
    val id: Int,
    val login: String,
    val node_id: String,
    val organizations_url: String,
    val received_events_url: String,
    val repos_url: String,
    val site_admin: Boolean,
    val starred_url: String,
    val subscriptions_url: String,
    val type: String,
    val url: String
){
    fun mapTo() = UserEntity(id = id.toString(), userName = login, image = avatar_url, api = "https://api.github.com")
}