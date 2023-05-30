package com.example.constructionriskassessment

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle;
import android.view.LayoutInflater


import android.view.View;
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.constructionriskassessment.database.Report
import com.example.constructionriskassessment.database.ReportDatabase
import com.example.constructionriskassessment.databinding.FragmentReportlistBinding
import java.io.ByteArrayOutputStream

class ReportListFragment: Fragment(), RecyclerViewAdapter.ItemClickListener{
	private lateinit var viewModel: ReportViewModel
	private lateinit var recyclerView: RecyclerView
	private lateinit var adapter: RecyclerViewAdapter
	private lateinit var binding: FragmentReportlistBinding
	private lateinit var bitmap: Bitmap


	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Binding the fragment_reportlist layout
		binding = DataBindingUtil.inflate(inflater, R.layout.fragment_reportlist, container, false)
		// Assigning the recyclerview of the layout to a variable named recyclerView
		recyclerView = binding.recyclerView1

		// Getting the instance of the database and getting the data access object (DA0) of that database
		val dao = ReportDatabase.getInstance(requireActivity().application).reportDao()
		// Calling ReportViewModelFactory that takes a constructor parameter DAO
		val factory = ReportViewModelFactory(dao)
		// ViewModel instance
		viewModel = ViewModelProvider(this,factory).get(ReportViewModel::class.java)


		initRecyclerView()

		binding.updateBtn.setOnClickListener {
			val hazardEdTxt = binding.updateHazardTxt.text.toString()
			val descEdTxt = binding.updateDescTxt.text.toString()
			val sevEdTxt = binding.updateSevTxt.text.toString()
			val stream = ByteArrayOutputStream()
			bitmap.compress(Bitmap.CompressFormat.PNG,100, stream)
			val imageView = stream.toByteArray()

			val report = Report(binding.updateHazardTxt.getTag(binding.updateHazardTxt.id).toString().toInt()
				,hazardEdTxt, descEdTxt, sevEdTxt, imageView)
			viewModel.updateReport(report)
		}
		return binding.root
	}

	private fun initRecyclerView(){
		// Setting the recyclerView as a LinearLayout
		recyclerView.layoutManager = LinearLayoutManager(requireContext())
		// Assigning RecyclerViewAdapter as the adapter for this recyclerview
		adapter = RecyclerViewAdapter(this)
		recyclerView.adapter = adapter
		displayReportList()

	}


	private fun displayReportList(){
		viewModel.reports.observe(this,{
			adapter.setList(it)
			adapter.notifyDataSetChanged()
		})
	}

	override fun onDeleteReportListener(report: Report) {
		viewModel.deleteReport(report)
	}

	override fun onItemClickListener(report: Report) {
		binding.updateHazardTxt.setText(report.typeOfHazard)
		binding.updateHazardTxt.setTag(binding.updateHazardTxt.id, report.id)
		binding.updateDescTxt.setText(report.description)
		binding.updateSevTxt.setText(report.sev_level)

		bitmap = BitmapFactory.decodeByteArray(report.image, 0, report.image.size)

		binding.updateImg.setImageBitmap(bitmap)
	}

}

	
	