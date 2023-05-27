package com.example.constructionriskassessment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.constructionriskassessment.database.Report


class RecyclerViewAdapter(): RecyclerView.Adapter<ViewHolder>() {
    private val reportList = ArrayList<Report>()

    // This function instantiate the item_list layout and give ViewHolder the layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.item_list, parent, false)
        return ViewHolder(listItem)
    }

    // This function specifies how many rows of the data to be displayed
    override fun getItemCount(): Int {
        return reportList.size
    }

    // This function is the one that changes the values of a component in the ViewHolder(layout)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(reportList[position])
    }

    fun setList(reports:List<Report>){
        reportList.clear()
        reportList.addAll(reports)
    }

}

// This class is the ViewHolder(layout) that will be displayed in the recyclerView
class ViewHolder(private val view:View): RecyclerView.ViewHolder(view){

    fun bind(report: Report){
        val myImageView = view.findViewById<ImageView>(R.id.list_img)
        val myTextView = view.findViewById<TextView>(R.id.list_txt)
        myTextView.text = "Report ${report.id.toString()}"
    }

    private fun nav(){
        view.findViewById<FrameLayout>(R.id.report_frame).setOnClickListener{
            it.findNavController().navigate(R.id.action_reportListFragment_to_riskAssessmentFragment)
        }
    }
    // This is to initialize or run the function nav()
    init {
        nav()
    }
}