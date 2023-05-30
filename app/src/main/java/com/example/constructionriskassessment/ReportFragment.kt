package com.example.constructionriskassessment

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle;
import android.view.LayoutInflater


import android.view.View;
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.constructionriskassessment.database.Report
import com.example.constructionriskassessment.database.ReportDatabase
import com.example.constructionriskassessment.databinding.FragmentReportBinding
import java.io.ByteArrayOutputStream

@Suppress("DEPRECATION")
class ReportFragment : Fragment() {
	private lateinit var submitBtn: Button
	private lateinit var hazardTxt: EditText
	private lateinit var descriptionTxt: EditText
	private lateinit var severityLvl: RadioGroup
	private lateinit var viewModel: ReportViewModel
	private lateinit var uploadBtn: Button
	private lateinit var displayImage: ImageView
	private lateinit var uploadTxt: TextView
	private lateinit var imageBitmap: Bitmap

	companion object {
		val IMAGE_REQUEST_CODE = 100
	}


	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Binding fragment_report layout
		val binding = DataBindingUtil.inflate<FragmentReportBinding>(
			inflater,
			R.layout.fragment_report,
			container,
			false
		)
		// Getting the instance of the database and getting the data access object (DA0) of that database
		val dao = ReportDatabase.getInstance(requireActivity().application).reportDao()
		// Calling ReportViewModelFactory that takes a constructor parameter DAO
		val factory = ReportViewModelFactory(dao)
		// ViewModel instance
		viewModel = ViewModelProvider(this, factory).get(ReportViewModel::class.java)

		// Assigning the layout components to a global variable
		submitBtn = binding.submitBtn
		hazardTxt = binding.hazardEdTxt
		descriptionTxt = binding.descriptionEdTxt
		severityLvl = binding.radioBtn
		uploadBtn = binding.uploadBtn
		displayImage = binding.displayImg
		uploadTxt = binding.uploadTxt


		submitBtn.setOnClickListener {
			if (hazardTxt.text.isEmpty() || descriptionTxt.text.isEmpty()) {
				Toast.makeText(context, "Please fill in the blanks", Toast.LENGTH_SHORT).show()
			} else {
				saveReportData()
				clearData()
				Toast.makeText(requireContext(),"Submit successfully!", Toast.LENGTH_SHORT).show()
			}
		}

		uploadBtn.setOnClickListener {
			uploadImage()
			uploadBtn.alpha = 0f
			uploadBtn.isEnabled = true
			uploadTxt.visibility = View.INVISIBLE
		}

		displayImage.setOnClickListener {
			uploadImage()
		}


		// Returning the layout
		return binding.root
	}

	// For saving the data on the database
	private fun saveReportData() {
		val hazard = hazardTxt.text.toString()
		val description = descriptionTxt.text.toString()
		val severityLevel = when (severityLvl.checkedRadioButtonId) {
			R.id.low_btn -> "Low"
			R.id.moderate_btn -> "Moderate"
			else -> "High"
		}
		val imageByteArray = bitmapToByteArray(imageBitmap)

		// Report data class needs a string argument which is why the text are converted to strings
		val report = Report(0, hazard, description, severityLevel, imageByteArray)
		// We use the insertReport for saving the data
		viewModel.insertReport(report)
	}

	// For clearing the EditText
	private fun clearData(){
		hazardTxt.setText("")
		descriptionTxt.setText("")
	}

	private fun uploadImage() {
		val intent = Intent(Intent.ACTION_PICK)
		intent.type = "image/*"
		startActivityForResult(intent, IMAGE_REQUEST_CODE)
	}

	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
		super.onActivityResult(requestCode, resultCode, data)
		if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
			val selectedImageUri = data?.data
			if (selectedImageUri != null) {
				displayImage.visibility = View.VISIBLE
				displayImage.setImageURI(selectedImageUri)
				displayImage.layoutParams.width = displayImage.width
				displayImage.layoutParams.height = displayImage.height

				imageBitmap = BitmapFactory.decodeStream(context?.contentResolver?.openInputStream(selectedImageUri))
			}
		}
	}

	private fun bitmapToByteArray(bitmap: Bitmap): ByteArray {
		val stream = ByteArrayOutputStream()
		bitmap.compress(Bitmap.CompressFormat.PNG,100, stream)
		return stream.toByteArray()
	}


}
