package com.example.constructionriskassessment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.constructionriskassessment.database.ReportDatabase
import com.example.constructionriskassessment.databinding.FragmentLoginBinding



class LoginFragment : Fragment() {
	private lateinit var usernameEdTxt: EditText
	private lateinit var passwordEdTxt: EditText
	private lateinit var viewModel: UserViewModel


	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater, R.layout.fragment_login, container, false)
		val dao = ReportDatabase.getInstance(requireActivity().application).userDao()
		val factory = UserViewModelFactory(dao)
		viewModel = ViewModelProvider(this, factory).get(UserViewModel::class.java)

		usernameEdTxt = binding.usernameEdTxt
		passwordEdTxt = binding.passwordEdTxt

		// Inside onCreateView()
		binding.loginBtn.setOnClickListener {
			val username = usernameEdTxt.text.toString()
			val password = passwordEdTxt.text.toString()

			viewModel.getUserByUsername(username).observe(viewLifecycleOwner) { user ->
				if (user == null) {
					Toast.makeText(requireContext(), "Username not registered", Toast.LENGTH_SHORT).show()
				} else {
					if (user.password == password) {
						it.findNavController().navigate(R.id.action_loginFragment_to_homeFragment2)
					} else {
						Toast.makeText(requireContext(), "Invalid password", Toast.LENGTH_SHORT).show()
					}
				}
			}
		}

		binding.regBtn.setOnClickListener {
			it.findNavController().navigate(R.id.action_loginFragment_to_registrationFragment2)
		}

		return binding.root
	}

}

