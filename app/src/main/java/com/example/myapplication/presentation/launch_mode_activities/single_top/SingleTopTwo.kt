package com.example.myapplication.presentation.launch_mode_activities.single_top

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.databinding.ActivitySingleTopTwoBinding

class SingleTopTwo : AppCompatActivity() {
    private lateinit var _viewBinding: ActivitySingleTopTwoBinding
    private lateinit var  navigateButton1: Button
    private lateinit var  navigateButton2: Button
    private lateinit var  navigateButton3: Button
    private lateinit var  backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        _viewBinding = ActivitySingleTopTwoBinding.inflate(layoutInflater)
        navigateButton1 = _viewBinding.singleTopNavigateButtonTwo1
        navigateButton2 = _viewBinding.singleTopNavigateButtonTwo2
        navigateButton3 = _viewBinding.singleTopNavigateButtonTwo3
        backButton = _viewBinding.singleTopNavigateButtonTwoBack

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