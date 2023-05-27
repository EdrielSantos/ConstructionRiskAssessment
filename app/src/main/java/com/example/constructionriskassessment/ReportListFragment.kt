package com.example.constructionriskassessment

import android.os.Bundle;
import android.provider.ContactsContract.Data
import android.view.LayoutInflater


import android.view.View;
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.constructionriskassessment.database.ReportDatabase
import com.example.constructionriskassessment.databinding.FragmentReportlistBinding
import com.example.constructionriskassessment.databinding.FragmentRiskassessmentBinding

class ReportListFragment: Fragment() {
	private lateinit var viewModel: ReportViewModel
	private lateinit var recyclerView: RecyclerView
	private lateinit var adapter: RecyclerViewAdapter
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Binding the fragment_reportlist layout
		val binding = DataBindingUtil.inflate<FragmentReportlistBinding>(inflater, R.layout.fragment_reportlist, container, false)
		// Assigning the recyclerview of the layout to a variable named recyclerView
		recyclerView = binding.recyclerView1

		// Getting the instance of the database and getting the data access object (DA0) of that database
		val dao = ReportDatabase.getInstance(requireActivity().application).reportDao()
		// Calling ReportViewModelFactory that takes a constructor parameter DAO
		val factory = ReportViewModelFactory(dao)
		// ViewModel instance
		viewModel = ViewModelProvider(this,factory).get(ReportViewModel::class.java)

		initRecyclerView()
		return binding.root
	}

	private fun initRecyclerView(){
		// Setting the recyclerView as a LinearLayout
		recyclerView.layoutManager = LinearLayoutManager(requireContext())
		// Assigning RecyclerViewAdapter as the adapter for this recyclerview
		adapter  = RecyclerViewAdapter()
		recyclerView.adapter = adapter

		displayReportList()
	}

	private fun displayReportList(){
		viewModel.reports.observe(this,{
			adapter.setList(it)
			adapter.notifyDataSetChanged()
		})
	}


}
	
	