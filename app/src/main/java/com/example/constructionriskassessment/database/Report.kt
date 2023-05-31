package com.example.constructionriskassessment.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "report_table")
data class Report(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "report_title")
    val typeOfHazard: String,
    @ColumnInfo(name = "report_description")
    val description: String,
    @ColumnInfo(name = "report_severity_level")
    val sev_level: String,
    @ColumnInfo(name = "report_image")
    val image: ByteArray
)


