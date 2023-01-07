package com.example.mytestwork.db

import android.content.Context
import androidx.room.Query
import com.example.mytestwork.api.dailymotion.DailymotionApi
import com.example.mytestwork.api.dailymotion.UserDailymotion
import com.example.mytestwork.api.github.GitHubApi
import com.example.mytestwork.api.github.UserGitHub

class UserRepository(val context: Context) {
    private val dailymotionApi: DailymotionApi = DailymotionApi.getInstance()
    private val gitHubApi: GitHubApi = GitHubApi.getInstance()
    private val userDatabase: UserDatabase = UserDatabase.getDatabase(context)
    private val userDao: UserDao = userDatabase.getDao()

    suspend fun getDailymotionUsers(): UserDailymotion{
        return dailymotionApi.getUsers()
    }
    suspend fun getGitHubUsers(): UserGitHub{
        return gitHubApi.getUsers()
    }

    suspend fun insert(userEntity: UserEntity){
        userDao.insert(userEntity)
    }
    suspend fun insertAll(listUserEntity:List<UserEntity>){
        userDao.insertAllUsers(listUserEntity)
    }

    suspend fun getAllUsers(): List<UserEntity>{
        return userDao.getAllUsers()
    }

    suspend fun deleteAllUsers(){
        userDao.deleteAllUsers()
    }
}