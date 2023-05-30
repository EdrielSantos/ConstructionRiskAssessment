package com.example.constructionriskassessment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.constructionriskassessment.database.User
import com.example.constructionriskassessment.database.UserDAO
import kotlinx.coroutines.launch

class UserViewModel (private val dao:UserDAO ): ViewModel() {


    fun getUserByUsername(username: String): LiveData<User?> {
        return dao.getUserByUsername(username)
    }
    fun  insertUser(user: User)=viewModelScope.launch{
        dao.insertUser(user)
    }

}