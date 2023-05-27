package com.example.constructionriskassessment

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater


import android.view.View;
import android.view.ViewGroup
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.constructionriskassessment.databinding.FragmentRiskassessmentBinding

class RiskAssessmentFragment: Fragment() {

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		val binding = DataBindingUtil.inflate<FragmentRiskassessmentBinding>(inflater, R.layout.fragment_riskassessment, container, false)

		return binding.root
	}
}
	
	