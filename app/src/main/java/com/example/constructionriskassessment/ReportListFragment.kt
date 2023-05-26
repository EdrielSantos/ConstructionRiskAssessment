package com.example.constructionriskassessment

import android.app.Activity;
import android.graphics.Color
import android.os.Bundle;
import android.view.LayoutInflater


import android.view.View;
import android.view.ViewGroup
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.constructionriskassessment.databinding.FragmentReportlistBinding

class ReportListFragment: Fragment() {
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		val binding = DataBindingUtil.inflate<FragmentReportlistBinding>(inflater, R.layout.fragment_reportlist, container, false)
		val recyclerView = binding.recyclerView1
		recyclerView.layoutManager = LinearLayoutManager(this.context)
		recyclerView.adapter = RecyclerViewAdapter()

		return binding.root
	}

}
	
	