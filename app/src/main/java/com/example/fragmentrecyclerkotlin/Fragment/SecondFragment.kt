package com.example.fragmentrecyclerkotlin.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fragmentrecyclerkotlin.R

class SecondFragment : Fragment() {
    lateinit var txt_second: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        txt_second = view.findViewById(R.id.txt_second)
        return view
    }

    public fun updateSecondText(str: String) {
        txt_second.setText(str)
    }

}