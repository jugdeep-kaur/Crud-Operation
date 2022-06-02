package com.example.myprojectapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(private val  onCardClick: (position: Int) -> Unit,
               private val foodList: List<Food>):RecyclerView.Adapter<ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //inflate
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.food_list_item,parent,false)

        return ViewHolder(view, onCardClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // add current item to the holder

        val itemVM = foodList[position]
        holder.ffood.text = itemVM.ffood
        holder.sfood.text = itemVM.sfood
    }

    override fun getItemCount(): Int {
        //size of the list/data source
        return foodList.size
    }
}
class ViewHolder(view: View, private val onCardClick:(position:Int)->Unit)
    :RecyclerView.ViewHolder(view), View.OnClickListener {
    init {
        itemView.setOnClickListener(this)
    }

    val ffood: TextView = view.findViewById(R.id.ffood)
    val sfood: TextView = view.findViewById(R.id.sfood)

    override fun onClick(v: View?) {
        val position = adapterPosition
        onCardClick(position)
    }


}




