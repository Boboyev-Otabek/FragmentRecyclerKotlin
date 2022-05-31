package com.example.fragmentrecyclerkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    fun initView() {
        val b_open = findViewById<Button>(R.id.b_open)
        b_open.setOnClickListener { openRuntimeActivity() }
    }


    fun openRuntimeActivity() {
        val intent = Intent(this, RuntimeActivity::class.java)
        startActivity(intent)
    }
}