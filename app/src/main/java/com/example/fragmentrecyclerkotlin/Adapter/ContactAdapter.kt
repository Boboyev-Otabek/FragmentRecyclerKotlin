package com.example.fragmentrecyclerkotlin.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentrecyclerkotlin.Fragment.FirstFragment
import com.example.fragmentrecyclerkotlin.Model.Contact
import com.example.fragmentrecyclerkotlin.R

class ContactAdapter(var contact: ArrayList<Contact>, var activity: FirstFragment) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return contact.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_item, parent, false)
        return ContactViewholder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var contacts: Contact = contact.get(position)
        if (holder is ContactViewholder) {
            holder.ism.setText(contacts.ism)
            holder.familiya.setText(contacts.familiya)
            holder.layout.setOnClickListener {
                activity.openDetail(contacts)
            }

        }
    }

    class ContactViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var layout: LinearLayout = itemView.findViewById(R.id.layout_id)
        var ism = itemView.findViewById<TextView>(R.id.ism)
        var familiya = itemView.findViewById<TextView>(R.id.familiya)


    }
}
