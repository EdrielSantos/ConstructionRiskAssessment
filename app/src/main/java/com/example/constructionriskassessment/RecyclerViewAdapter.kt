package com.example.constructionriskassessment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView


class RecyclerViewAdapter: RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.item_list, parent, false)
        return ViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.myButton.text = "Report $position"
    }


}


class ViewHolder(val view:View): RecyclerView.ViewHolder(view){
    val myImageView = view.findViewById<ImageView>(R.id.list_img)
    val myButton = view.findViewById<Button>(R.id.list_btn)
    fun nav(){
        myButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_reportListFragment_to_riskAssessmentFragment)
        }
    }
    init {
        nav()
    }
}