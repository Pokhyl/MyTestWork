package com.example.mytestwork.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = REPLACE)
    suspend fun insert(userEntity: UserEntity)
    @Query("select * from users")
    suspend fun getAllUsers(): List<UserEntity>
    @Query("delete from users")
    suspend fun deleteAllUsers()
    @Insert(onConflict = REPLACE)
    suspend fun insertAllUsers(listUserEntity: List<UserEntity>)
}