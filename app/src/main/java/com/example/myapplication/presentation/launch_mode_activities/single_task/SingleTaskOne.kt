package com.example.myapplication.presentation.launch_mode_activities.single_task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.databinding.ActivitySingleTaskOneBinding

class SingleTaskOne : AppCompatActivity() {
    private lateinit var _viewBinding: ActivitySingleTaskOneBinding
    private lateinit var  navigateButton1: Button
    private lateinit var  navigateButton2: Button
    private lateinit var  navigateButton3: Button
    private lateinit var  backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        _viewBinding = ActivitySingleTaskOneBinding.inflate(layoutInflater)
        navigateButton1 = _viewBinding.singleTaskNavigateButtonOne1
        navigateButton2 = _viewBinding.singleTaskNavigateButtonOne2
        navigateButton3 = _viewBinding.singleTaskNavigateButtonOne3
        backButton = _viewBinding.singleTaskNavigateButtonOneBack

        super.onCreate(savedInstanceState)
        setContentView(_viewBinding.root)

        navigateButton1.setOnClickListener { navigate1() }
        navigateButton2.setOnClickListener { navigate2() }
        navigateButton3.setOnClickListener { navigate3() }
        backButton.setOnClickListener { this.finish() }
    }

    private fun navigate1() {
        val intent = Intent(this, SingleTaskOne::class.java)
        startActivity(intent)
    }
    private fun navigate2() {
        val intent = Intent(this, SingleTaskTwo::class.java)
        startActivity(intent)
    }
    private fun navigate3() {
        val intent = Intent(this, SingleTaskThree::class.java)
        startActivity(intent)
    }
}