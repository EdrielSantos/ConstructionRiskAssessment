package com.example.constructionriskassessment

import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.constructionriskassessment.database.Report



class RecyclerViewAdapter(private val listener: ItemClickListener): RecyclerView.Adapter<ViewHolder>() {
    private val reportList = ArrayList<Report>()


    // This function instantiate the item_list layout and give ViewHolder the layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.item_list, parent, false)
        return ViewHolder(listItem, listener)
    }

    // This function specifies how many rows of the data to be displayed
    override fun getItemCount(): Int {
        return reportList.size
    }

    // This function is the one that changes the values of a component in the ViewHolder(layout)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            listener.onItemClickListener(reportList[position])
        }
        holder.bind(reportList[position])
    }

    fun setList(reports:List<Report>){
        reportList.clear()
        reportList.addAll(reports)
    }

    interface ItemClickListener{
        fun onDeleteReportListener(report: Report)
        fun onItemClickListener(report: Report)
    }


}

// This class is the ViewHolder(layout) that will be displayed in the recyclerView
class ViewHolder(private val view1:View, private val listener: RecyclerViewAdapter.ItemClickListener): RecyclerView.ViewHolder(view1){

    fun bind(report: Report) {
        val myTextView = view1.findViewById<TextView>(R.id.list_txt)
        val myHazardTv = view1.findViewById<TextView>(R.id.list_type)
        val myDescriptionTv = view1.findViewById<TextView>(R.id.list_desc)
        val mySevLvlTv = view1.findViewById<TextView>(R.id.list_sev)
        val deleteButton = view1.findViewById<Button>(R.id.del_btn)
        val myImageView = view1.findViewById<ImageView>(R.id.list_img)
        val bitmap = BitmapFactory.decodeByteArray(report.image, 0, report.image.size)

        myTextView.text = "Report ${report.id.toString()}"
        myHazardTv.text = "${report.typeOfHazard.toString()}"
        myDescriptionTv.text = "${report.description.toString()}"
        mySevLvlTv.text = "${report.sev_level.toString()}"
        myImageView.setImageBitmap(bitmap)


        deleteButton.setOnClickListener {
            listener.onDeleteReportListener(report)
        }
    }

}