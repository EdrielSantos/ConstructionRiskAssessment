package com.example.constructionriskassessment.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDAO {
    @Insert
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM user_table WHERE user_account = :username")
    fun getUserByUsername(username: String): LiveData<User?>
}
