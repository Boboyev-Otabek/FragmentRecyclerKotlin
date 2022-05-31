package com.example.fragmentrecyclerkotlin.Fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentrecyclerkotlin.Adapter.ContactAdapter
import com.example.fragmentrecyclerkotlin.Model.Contact
import com.example.fragmentrecyclerkotlin.R

class FirstFragment : Fragment() {
    lateinit var listener: FirstListener
    val TAG = FirstFragment::class.java.toString()
    lateinit var recyclerview: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_first, container, false)
        initView(view)
        return view
    }

    fun initView(view: View) {

        recyclerview = view.findViewById(R.id.recyclerview)
        recyclerview.layoutManager = GridLayoutManager(context, 1)

        var contact = AddContact()
        refreshadapter(contact)
    }

    fun refreshadapter(contact: ArrayList<Contact>) {
        var adapter = ContactAdapter(contact, this)
        recyclerview.adapter = adapter

    }

    public fun openDetail(contact: Contact) {
        Log.d("@@@", "item is clicked " + contact.ism)
        listener.onFirstSend(contact.ism + "\n\n" + contact.familiya)
    }

    fun AddContact(): ArrayList<Contact> {
        var contact = ArrayList<Contact>()
        for (i in 0..21 step 1) {
            contact.add(Contact("Otabek $i", "Boboyev $i"))
        }
        return contact
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FirstListener) {
            listener = context as FirstListener
        } else {
            throw RuntimeException(context.toString())
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener == null
    }

    interface FirstListener {
        fun onFirstSend(str: String?)
    }
}