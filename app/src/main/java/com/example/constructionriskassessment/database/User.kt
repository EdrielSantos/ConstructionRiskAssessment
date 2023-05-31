package com.example.constructionriskassessment.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "user_account")
    val username: String,
    @ColumnInfo(name = "user_password")
    val password: String,

)
