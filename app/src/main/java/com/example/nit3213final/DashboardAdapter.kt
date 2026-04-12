package com.example.nit3213final

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DashboardAdapter(private val list: List<Entity>) :
    RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val type: TextView = itemView.findViewById(R.id.type)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dashboard, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = list[position]

        holder.title.text = item.name
        holder.type.text = item.type

        // 🔥 CLICK → OPEN DETAILS SCREEN
        holder.itemView.setOnClickListener {

            val intent = Intent(holder.itemView.context, DetailsActivity::class.java)

            intent.putExtra("title", item.name)
            intent.putExtra("type", item.type)
            intent.putExtra("desc", item.description)

            holder.itemView.context.startActivity(intent)
        }
    }
}