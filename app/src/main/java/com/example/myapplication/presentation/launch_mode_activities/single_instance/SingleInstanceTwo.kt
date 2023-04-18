package com.example.myapplication.presentation.launch_mode_activities.single_instance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.databinding.ActivitySingleInstanceTwoBinding

class SingleInstanceTwo : AppCompatActivity() {
    private lateinit var _viewBinding: ActivitySingleInstanceTwoBinding
    private lateinit var  navigateButton1: Button
    private lateinit var  navigateButton2: Button
    private lateinit var  navigateButton3: Button
    private lateinit var  backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        _viewBinding = ActivitySingleInstanceTwoBinding.inflate(layoutInflater)
        navigateButton1 = _viewBinding.singleInstanceNavigateButtonTwo1
        navigateButton2 = _viewBinding.singleInstanceNavigateButtonTwo2
        navigateButton3 = _viewBinding.singleInstanceNavigateButtonTwo3
        backButton = _viewBinding.singleInstanceNavigateButtonTwoBack

        super.onCreate(savedInstanceState)
        setContentView(_viewBinding.root)

        navigateButton1.setOnClickListener { navigate1() }
        navigateButton2.setOnClickListener { navigate2() }
        navigateButton3.setOnClickListener { navigate3() }
        backButton.setOnClickListener { this.finish() }
    }

    private fun navigate1() {
        val intent = Intent(this, SingleInstanceOne::class.java)
        startActivity(intent)
    }
    private fun navigate2() {
        val intent = Intent(this, SingleInstanceTwo::class.java)
        startActivity(intent)
    }
    private fun navigate3() {
        val intent = Intent(this, SingleInstanceThree::class.java)
        startActivity(intent)
    }
}