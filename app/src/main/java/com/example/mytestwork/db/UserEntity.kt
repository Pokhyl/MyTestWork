package com.example.mytestwork.db

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "users")
data class UserEntity (
    @PrimaryKey
    var id:String,
    var userName: String,
    var image: String,
    var api:String
        ): Parcelable