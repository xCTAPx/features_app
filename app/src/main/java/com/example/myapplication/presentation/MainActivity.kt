package com.example.myapplication.presentation

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.annotation.RequiresApi
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.data.ScreensParams
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.domain.FeatureController
import com.example.myapplication.presentation.fragments.First
import com.example.myapplication.presentation.fragments.Second
import com.example.myapplication.presentation.fragments.Third
import com.example.myapplication.presentation.launch_mode_activities.EntryPoint
import kotlin.math.absoluteValue

class
MainActivity : AppCompatActivity() {
    // Common elements
    private lateinit var binding: ActivityMainBinding
    private lateinit var toFeaturesListButton: Button
    private lateinit var userNameInput: EditText
    private lateinit var currentFeatureTitle: TextView
    private lateinit var startFeatureButton: Button

    // Fragment feature elements
    private lateinit var fragmentContainer: FrameLayout
    private lateinit var fragmentButton1: Button
    private lateinit var fragmentButton2: Button
    private lateinit var fragmentButton3: Button

    private var currentFeature: String? = null

    private val featuresController = FeatureController()

    private val launcher = registerForActivityResult(StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            currentFeature = result.data?.getStringExtra(ScreensParams.CURRENT_FEATURE)
            currentFeatureTitle.text = currentFeature
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        toFeaturesListButton = binding.toFeaturesListButton
        userNameInput = binding.userNameInput
        currentFeatureTitle = binding.currentFeature
        startFeatureButton = binding.startFeature
        fragmentContainer = binding.fragmentContainer
        fragmentButton1 = binding.fragmentButton1
        fragmentButton2 = binding.fragmentButton2
        fragmentButton3 = binding.fragmentButton3

        setContentView(binding.root)

        toFeaturesListButton.setOnClickListener { navigateToFeaturesList() }
        startFeatureButton.setOnClickListener { startFeature() }
        fragmentButton1.setOnClickListener { showFragment(First()) }
        fragmentButton2.setOnClickListener { showFragment(Second()) }
        fragmentButton3.setOnClickListener { showFragment(Third()) }
    }

    private fun navigateToFeaturesList() {
        val intent = Intent(this@MainActivity, ListActivity::class.java)

        val userName = userNameInput.text.toString().trim()

        if (userName == "") {
            userNameInput.error = getString(R.string.enter_any_name)
            return
        }

        intent.putExtra(ScreensParams.USER_NAME, userName)

        launcher.launch(intent)
    }

    private fun navigateToALMEntryPoint() {
        val intent = Intent(this@MainActivity, EntryPoint::class.java)
        startActivity(intent)
    }

    private fun navigateToRecyclerViewScreen() {

    }

    private fun startFeature() {
        if (currentFeature == null) return

        getFragmentsFeatureVisibility()

        val targetScreen = featuresController.start(currentFeature!!)
        when (targetScreen) {
            "ListActivity" -> navigateToFeaturesList()
            "LM Entry Point" -> navigateToALMEntryPoint()
            "Recycler View" -> navigateToRecyclerViewScreen()
            null -> return
            else -> return
        }
    }

    private fun getFragmentsFeatureVisibility() {
        fragmentContainer.visibility = if (currentFeature == "Fragments") View.VISIBLE else View.INVISIBLE
        fragmentButton1.visibility = if (currentFeature == "Fragments") View.VISIBLE else View.INVISIBLE
        fragmentButton2.visibility = if (currentFeature == "Fragments") View.VISIBLE else View.INVISIBLE
        fragmentButton3.visibility = if (currentFeature == "Fragments") View.VISIBLE else View.INVISIBLE
    }

    private fun showFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(fragmentContainer.id, fragment).commit()
    }
}