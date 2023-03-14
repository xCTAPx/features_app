package com.example.myapplication.presentation.launch_mode_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.myapplication.databinding.ActivityEntryPointBinding

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

    private fun startStandardModeJourney() {}
    private fun startSingleTopModeJourney() {}
    private fun startSingleTaskModeJourney() {}
    private fun startSingleInstanceJourney() {}
}