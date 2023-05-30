package com.example.constructionriskassessment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.constructionriskassessment.database.Report
import com.example.constructionriskassessment.database.ReportDatabase
import com.example.constructionriskassessment.database.User
import com.example.constructionriskassessment.databinding.FragmentLoginBinding
import com.example.constructionriskassessment.databinding.FragmentRegistrationBinding


class RegistrationFragment : Fragment() {
    private lateinit var regUsername: EditText
    private lateinit var regPassword: EditText
    private lateinit var viewModel: UserViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentRegistrationBinding>(inflater, R.layout.fragment_registration, container, false)
        val dao = ReportDatabase.getInstance(requireActivity().application).userDao()
        val factory = UserViewModelFactory(dao)
        viewModel = ViewModelProvider(this, factory).get(UserViewModel::class.java)

        regUsername = binding.regUsername
        regPassword = binding.regPassword
        binding.enterBtn.setOnClickListener {
            if (regUsername.text.isEmpty() || regPassword.text.isEmpty()) {
                Toast.makeText(context, "Please fill in the blanks", Toast.LENGTH_SHORT).show()
            } else {
                saveUserData()
                Toast.makeText(requireContext(),"Submit successfully!", Toast.LENGTH_SHORT).show()
            }
            it.findNavController().navigate(R.id.action_registrationFragment_to_loginFragment2)
        }
        return binding.root
    }

    private fun saveUserData() {
        val username = regPassword.text.toString()
        val password = regUsername.text.toString()
        val user = User(0, password,username)
        viewModel.insertUser(user)
    }

}