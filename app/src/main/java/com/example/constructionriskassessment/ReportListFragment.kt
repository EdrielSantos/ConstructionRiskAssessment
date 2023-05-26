package com.example.constructionriskassessment

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater


import android.view.View;
import android.view.ViewGroup
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment

class ReportListFragment: Fragment() {
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		return inflater.inflate(R.layout.fragment_reportlist, container, false)
	}

}
	
	