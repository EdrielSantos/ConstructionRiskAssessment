package com.example.constructionriskassessment

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout


import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.constructionriskassessment.databinding.ActivityMainBinding
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

		setHasOptionsMenu(true)
		return binding.root

	}

	override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
		super.onCreateOptionsMenu(menu, inflater)
		inflater.inflate(R.menu.options_menu, menu)
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		return  NavigationUI.onNavDestinationSelected(item,requireView().findNavController())
				|| super.onOptionsItemSelected(item)
	}


}

