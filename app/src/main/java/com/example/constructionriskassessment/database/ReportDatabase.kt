package com.example.constructionriskassessment.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Report::class, User::class], version = 3)
abstract class ReportDatabase : RoomDatabase() {
    abstract fun userDao(): UserDAO
    abstract fun reportDao(): ReportDAO

    companion object {
        @Volatile
        private var INSTANCE: ReportDatabase? = null

        fun getInstance(context: Context): ReportDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ReportDatabase::class.java,
                        "ReportDatabase"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
