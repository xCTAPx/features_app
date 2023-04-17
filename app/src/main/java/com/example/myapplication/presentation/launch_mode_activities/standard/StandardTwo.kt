package com.example.myapplication.presentation.launch_mode_activities.standard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.databinding.ActivityStandardTwoBinding

class StandardTwo : AppCompatActivity() {
    private lateinit var _viewBinding: ActivityStandardTwoBinding
    private lateinit var  navigateButton1: Button
    private lateinit var  navigateButton2: Button
    private lateinit var  backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        _viewBinding = ActivityStandardTwoBinding.inflate(layoutInflater)
        navigateButton1 = _viewBinding.standardNavigateButtonTwo1
        navigateButton2 = _viewBinding.standardNavigateButtonTwo2
        backButton = _viewBinding.standardNavigateButtonOneBack

        super.onCreate(savedInstanceState)
        setContentView(_viewBinding.root)

        navigateButton1.setOnClickListener { navigate1() }
        navigateButton2.setOnClickListener { navigate2() }
        backButton.setOnClickListener { this.finish() }
    }

    private fun navigate1() {
        val intent = Intent(this, StandardOne::class.java)
        startActivity(intent)
    }
    private fun navigate2() {
        val intent = Intent(this, StandardTwo::class.java)
        startActivity(intent)
    }
}