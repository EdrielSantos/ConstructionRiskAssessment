package com.example.constructionriskassessment.database

import android.widget.RadioButton
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Blob


@Entity(tableName = "report_table")
data class Report(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "report_title")
    val typeOfHazard: String,
    @ColumnInfo(name = "report_description")
    val description: String,
    @ColumnInfo(name = "report_severity_level")
    val sev_level: String
)


