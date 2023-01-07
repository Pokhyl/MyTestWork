package com.example.mytestwork

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mytestwork.api.dailymotion.UserDailymotion
import com.example.mytestwork.api.github.UserGitHub
import com.example.mytestwork.db.UserEntity
import com.example.mytestwork.db.UserRepository
import kotlinx.coroutines.launch

class UsersViewModel(application: Application): AndroidViewModel(application) {
    lateinit var  repository: UserRepository
    var userEnityLiveDat = MutableLiveData<List<UserEntity>>()
    init {
        repository = UserRepository(application)
    }
    fun getUsersApi(){
        var listUserEntity = mutableListOf<UserEntity>()
        viewModelScope.launch {
         var dailymotion = repository.getDailymotionUsers()
         var gitHubList = repository.getGitHubUsers()
            for (d in dailymotion.list){
                listUserEntity.add(d.mapTo())
            }
            for(g in gitHubList){
                listUserEntity.add(g.mapTo())
            }
            insertAll(listUserEntity)
        }

    }


     fun insert(userEntity: UserEntity){
         viewModelScope.launch {
             repository.insert(userEntity)
         }
    }
    fun insertAll(listUserEntity: List<UserEntity>){
        println(listUserEntity)
        viewModelScope.launch {
            repository.insertAll(listUserEntity)
        }
    }

     fun getAllUsers(){
         viewModelScope.launch {
             userEnityLiveDat.postValue(repository.getAllUsers())
         }
    }

     fun deleteAllUsers(){
         viewModelScope.launch {
             repository.deleteAllUsers()
         }
    }
}