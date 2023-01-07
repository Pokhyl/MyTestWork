package com.example.mytestwork.api.github

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface GitHubApi {
    @GET("/users")
    suspend fun getUsers(): UserGitHub

    companion object {
       private var retrofitService: GitHubApi? = null

        fun getInstance() : GitHubApi {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.github.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(GitHubApi::class.java)
            }
            return retrofitService!!
        }
    }
}