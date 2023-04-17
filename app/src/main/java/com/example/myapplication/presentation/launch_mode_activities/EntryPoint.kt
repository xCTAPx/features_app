package com.example.myapplication.presentation.launch_mode_activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.myapplication.databinding.ActivityEntryPointBinding
import com.example.myapplication.presentation.launch_mode_activities.single_task.SingleTaskOne
import com.example.myapplication.presentation.launch_mode_activities.single_top.SingleTopOne
import com.example.myapplication.presentation.launch_mode_activities.standard.StandardOne

class EntryPoint : AppCompatActivity() {
    lateinit var binding: ActivityEntryPointBinding
    lateinit var standardModeButton: Button
    lateinit var singleTopModeButton: Button
    lateinit var singleTaskModeButton: Button
    lateinit var singleInstanceModeButton: Button
    lateinit var closeButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEntryPointBinding.inflate(layoutInflater)
        standardModeButton = binding.lmStandardButton
        singleTopModeButton = binding.lmSingleTopButton
        singleTaskModeButton = binding.lmSingleTaskButton
        singleInstanceModeButton = binding.lmSingleInstanceButton
        closeButton = binding.closeIcon

        setContentView(binding.root)

        closeButton.setOnClickListener { finish() }
        standardModeButton.setOnClickListener { startStandardModeJourney() }
        singleTopModeButton.setOnClickListener { startSingleTopModeJourney() }
        singleTaskModeButton.setOnClickListener { startSingleTaskModeJourney() }
        singleInstanceModeButton.setOnClickListener { startSingleInstanceJourney() }
    }

    private fun startStandardModeJourney() {
        val intent = Intent(this, StandardOne::class.java)
        startActivity(intent)
    }
    private fun startSingleTopModeJourney() {
        val intent = Intent(this, SingleTopOne::class.java)
        startActivity(intent)
    }
    private fun startSingleTaskModeJourney() {
        val intent = Intent(this, SingleTaskOne::class.java)
        startActivity(intent)
    }
    private fun startSingleInstanceJourney() {}
}