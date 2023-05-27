package com.example.constructionriskassessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.constructionriskassessment.database.ReportDatabase
import com.example.constructionriskassessment.databinding.ActivityMainBinding
import com.example.constructionriskassessment.databinding.FragmentLoginBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

    }
}