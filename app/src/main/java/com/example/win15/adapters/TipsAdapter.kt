package com.example.win15.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.win15.R
import com.example.win15.models.Tipsandtrick

class TipsAdapter(val list: List<Tipsandtrick>):RecyclerView.Adapter<TipsAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.tips_item, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding(list[position].title, list[position].definition)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class Holder(item: View):RecyclerView.ViewHolder(item){
        val textViewTitle = item.findViewById<TextView>(R.id.tips_title)
        val textViewDefinition = item.findViewById<TextView>(R.id.tips_definition)
        fun binding(title:String, definition: String){
            textViewTitle.text = title
            textViewDefinition.text = definition
        }
    }
}