package com.example.myapplication.presentation.launch_mode_activities.single_top

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.databinding.ActivitySingleTopThreeBinding

class SingleTopThree : AppCompatActivity() {
    private lateinit var _viewBinding: ActivitySingleTopThreeBinding
    private lateinit var  navigateButton1: Button
    private lateinit var  navigateButton2: Button
    private lateinit var  navigateButton3: Button
    private lateinit var  backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        _viewBinding = ActivitySingleTopThreeBinding.inflate(layoutInflater)
        navigateButton1 = _viewBinding.singleTaskNavigateButtonThree1
        navigateButton2 = _viewBinding.singleTaskNavigateButtonThree2
        navigateButton3 = _viewBinding.singleTaskNavigateButtonThree3
        backButton = _viewBinding.singleTaskNavigateButtonThreeBack

        super.onCreate(savedInstanceState)
        setContentView(_viewBinding.root)

        navigateButton1.setOnClickListener { navigate1() }
        navigateButton2.setOnClickListener { navigate2() }
        navigateButton3.setOnClickListener { navigate3() }
        backButton.setOnClickListener { this.finish() }
    }

    private fun navigate1() {
        val intent = Intent(this, SingleTopOne::class.java)
        startActivity(intent)
    }
    private fun navigate2() {
        val intent = Intent(this, SingleTopTwo::class.java)
        startActivity(intent)
    }
    private fun navigate3() {
        val intent = Intent(this, SingleTopThree::class.java)
        startActivity(intent)
    }
}