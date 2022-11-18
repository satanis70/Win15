package com.example.win15.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.win15.R
import com.example.win15.models.Faq

class FaqAdapter(val list: List<Faq>):RecyclerView.Adapter<FaqAdapter.FaqHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaqHolder {
        return FaqHolder(LayoutInflater.from(parent.context).inflate(R.layout.faq_item, parent, false))
    }

    override fun onBindViewHolder(holder: FaqHolder, position: Int) {
        holder.binding(list[position].title, list[position].definition)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class FaqHolder(item: View):RecyclerView.ViewHolder(item){
        val textViewTitle = item.findViewById<TextView>(R.id.faq_title)
        val textViewDefinition = item.findViewById<TextView>(R.id.faq_definition)
        fun binding(title: String, definition: String){
            textViewTitle.text = title
            textViewDefinition.text = definition
        }
    }
}