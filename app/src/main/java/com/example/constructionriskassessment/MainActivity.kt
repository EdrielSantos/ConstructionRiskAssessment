package com.example.constructionriskassessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.constructionriskassessment.databinding.FragmentRiskassessmentBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<FragmentRiskassessmentBinding>(this,R.layout.fragment_riskassessment)


    }
}