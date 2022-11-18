package com.example.win15.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.win15.R
import com.example.win15.models.Strategy

class StrategyAdapter(val list: List<Strategy>):RecyclerView.Adapter<StrategyAdapter.StrategyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StrategyHolder {
        return StrategyHolder(LayoutInflater.from(parent.context).inflate(R.layout.strategy_item, parent,false))
    }

    override fun onBindViewHolder(holder: StrategyHolder, position: Int) {
        holder.binding(list[position].title, list[position].definition)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class StrategyHolder(item: View):RecyclerView.ViewHolder(item){
        val textViewTitle = item.findViewById<TextView>(R.id.strategy_title)
        val textViewDefinition = item.findViewById<TextView>(R.id.strategy_definition)
        fun binding(title: String, definition: String){
            textViewTitle.text = title
            textViewDefinition.text = definition
        }
    }
}