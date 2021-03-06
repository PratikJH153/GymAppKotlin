package com.example.gymapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GlobalUserAdapter(val context: Context, var allUsers: List<User>) :
    RecyclerView.Adapter<GlobalUserAdapter.ViewHolder>() {

    private val listDp = listOf<Int>(
        R.drawable.ic1,
        R.drawable.ic2,
        R.drawable.ic3,
        R.drawable.ic4,
    )

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dpUser = itemView.findViewById<ImageView>(R.id.dp_user)
        val nameView = itemView.findViewById<TextView>(R.id.nameView)
        val emailView = itemView.findViewById<TextView>(R.id.emailView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.global_user_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem:User = allUsers[position]
        var proper = currentItem.iconIndex.toString()

        if(proper==null || proper=="")
            proper = "0"

        holder.dpUser.setImageResource(listDp[proper.toInt()])
        holder.nameView.text = currentItem.username
        holder.emailView.text = currentItem.email
    }

    override fun getItemCount(): Int {
        return allUsers.size
    }
}