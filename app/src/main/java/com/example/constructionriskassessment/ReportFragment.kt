
package com.example.constructionriskassessment

import android.app.Application
import android.os.Bundle;
import android.view.LayoutInflater


import android.view.View;
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
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
	// Binding fragment_report layout
	val binding = DataBindingUtil.inflate<FragmentReportBinding>(inflater,R.layout.fragment_report,container,false)
	// Getting the instance of the database and getting the data access object (DA0) of that database
	val dao = ReportDatabase.getInstance(requireActivity().application).reportDao()
	// Calling ReportViewModelFactory that takes a constructor parameter DAO
	val factory = ReportViewModelFactory(dao)
	// ViewModel instance
	viewModel = ViewModelProvider(this,factory).get(ReportViewModel::class.java)

	// Assigning the layout components to a global variable
	submitBtn = binding.submitBtn
	hazardTxt = binding.hazardEdTxt
	descriptionTxt = binding.descriptionEdTxt
	severityLvl = binding.radioBtn


	submitBtn.setOnClickListener {
		if(hazardTxt.text.isEmpty() || descriptionTxt.text.isEmpty())
		{
			Toast.makeText(context, "Please fill in the blanks", Toast.LENGTH_SHORT).show()
		}
		else{
			saveReportData()
			clearData()
		}
	}

	// Returning the layout
	return binding.root
	}

	// For saving the data on the database
	private fun saveReportData(){
		val hazard = hazardTxt.text.toString()
		val description = descriptionTxt.text.toString()
		val severityLevel = when(severityLvl.checkedRadioButtonId){
			R.id.low_btn -> "Low"
			R.id.moderate_btn -> "Moderate"
			else -> "High"
		}
		// Report data class needs a string argument which is why the text are converted to strings
		val report = Report(0,hazard,description,severityLevel)
		// We use the insertReport for saving the data
		viewModel.insertReport(report)
	}

	// For clearing the EditText
	private fun clearData(){
		hazardTxt.setText("")
		descriptionTxt.setText("")
	}


}
	
	