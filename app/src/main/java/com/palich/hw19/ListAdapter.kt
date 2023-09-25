package com.palich.hw19

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ListAdapter (private var items: List<Employee> = emptyList()): RecyclerView.Adapter<EmployeeViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val listItemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return EmployeeViewHolder(listItemView)
    }

    override fun getItemCount(): Int=items.size

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.name.text = items[position].name
        holder.position.text = items[position].position
    }

    fun updateItems(newItems: List<Employee>){
        items = newItems
        notifyDataSetChanged()
    }

}

class EmployeeViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
    val name:TextView = itemView.findViewById(R.id.name)
    val position:TextView = itemView.findViewById(R.id.position)
}