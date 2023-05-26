package com.example.constructionriskassessment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil


import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.constructionriskassessment.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {

		val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater, R.layout.fragment_home, container, false)

		binding.sendReportBtn.setOnClickListener {
			it.findNavController().navigate(R.id.action_homeFragment2_to_reportFragment)
		}

		binding.manageRiskBtn.setOnClickListener {
			it.findNavController().navigate(R.id.action_homeFragment2_to_reportListFragment)
		}

		return binding.root

	}

}

