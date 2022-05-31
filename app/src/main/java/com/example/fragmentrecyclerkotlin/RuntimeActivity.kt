package com.example.fragmentrecyclerkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmentrecyclerkotlin.Fragment.FirstFragment
import com.example.fragmentrecyclerkotlin.Fragment.SecondFragment

class RuntimeActivity : AppCompatActivity(),FirstFragment.FirstListener {
    lateinit var firstFragment:FirstFragment
    lateinit var secondFragment:SecondFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_runtime)
        initView()
    }

    override fun onFirstSend(str: String?) {
        secondFragment.updateSecondText(str!!)
    }


    fun initView() {
        firstFragment = FirstFragment()
        secondFragment = SecondFragment()
        supportFragmentManager.beginTransaction().replace(R.id.firstfragnent, firstFragment)
            .replace(R.id.secondfragment, secondFragment).commit()
    }
}