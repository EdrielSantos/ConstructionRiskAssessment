package com.example.constructionriskassessment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil


import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.constructionriskassessment.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater, R.layout.fragment_login, container, false)

		binding.loginBtn.setOnClickListener {
			it.findNavController().navigate(R.id.action_loginFragment_to_homeFragment2)
		}

		return binding.root
	}

}
	
	