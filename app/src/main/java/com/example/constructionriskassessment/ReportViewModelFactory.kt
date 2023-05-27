package com.example.constructionriskassessment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException
import com.example.constructionriskassessment.database.ReportDAO

class ReportViewModelFactory(private val dao: ReportDAO):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ReportViewModel::class.java)){
            return ReportViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }

}