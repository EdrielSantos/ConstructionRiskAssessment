package com.example.constructionriskassessment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.constructionriskassessment.database.Report
import com.example.constructionriskassessment.database.ReportDAO
import kotlinx.coroutines.launch

class ReportViewModel(private val dao: ReportDAO): ViewModel() {

    val reports = dao.getAllReports()

    fun insertReport(report: Report)=viewModelScope.launch{
        dao.addReport(report)
    }

    fun deleteReport(report: Report)=viewModelScope.launch {
        dao.deleteReport(report)
    }

    fun updateReport(report:Report)=viewModelScope.launch {
        dao.updateReport(report)
    }


}