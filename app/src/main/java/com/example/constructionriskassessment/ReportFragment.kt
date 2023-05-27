
package com.example.constructionriskassessment

import android.app.Application
import android.os.Bundle;
import android.view.LayoutInflater


import android.view.View;
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.constructionriskassessment.ReportViewModelFactory
import com.example.constructionriskassessment.ReportViewModel
import com.example.constructionriskassessment.database.Report
import com.example.constructionriskassessment.database.ReportDAO
import com.example.constructionriskassessment.database.ReportDatabase
import com.example.constructionriskassessment.databinding.FragmentReportBinding

class ReportFragment : Fragment() {
	private lateinit var submitBtn: Button
	private lateinit var hazardTxt: EditText
	private lateinit var descriptionTxt: EditText
	private lateinit var severityLvl: RadioGroup
	private lateinit var viewModel: ReportViewModel


	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
	val binding = DataBindingUtil.inflate<FragmentReportBinding>(inflater,R.layout.fragment_report,container,false)
	val dao = ReportDatabase.getInstance(requireActivity().application).reportDao()
	val factory = ReportViewModelFactory(dao)
	viewModel = ViewModelProvider(this, factory).get(ReportViewModel::class.java)


	submitBtn = binding.submitBtn
	hazardTxt = binding.hazardEdTxt
	descriptionTxt = binding.descriptionEdTxt
	severityLvl = binding.radioBtn

	submitBtn.setOnClickListener {
		saveReportData()
		clearData()
	}


	return binding.root
	}

	private fun saveReportData(){
		val hazard = hazardTxt.text.toString()
		val description = descriptionTxt.text.toString()
		val severityLevel = when(severityLvl.checkedRadioButtonId){
			R.id.low_btn -> "Low"
			R.id.moderate_btn -> "Moderate"
			else -> "High"
		}
		val report = Report(0,hazard,description,severityLevel)
		viewModel.insertReport(report)
	}

	private fun clearData(){
		hazardTxt.setText("")
		descriptionTxt.setText("")
	}


}
	
	