package com.example.constructionriskassessment.database

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface ReportDAO {

    @Insert
    suspend fun addReport(report:Report)

    @Update
    suspend fun updateReport(report:Report)

    @Delete
    suspend fun deleteReport(report: Report)

    @Query("SELECT * FROM report_table")
    fun getAllReports(): LiveData<List<Report>>


}