package com.example.myapplication.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.myapplication.data.ScreensParams
import com.example.myapplication.data.featuresList
import com.example.myapplication.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding
    private lateinit var list: LinearLayout
    private lateinit var userName: TextView
    private lateinit var closeButton: ImageView
    private var selectedFeature: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        list = binding.list
        userName = binding.userName
        closeButton = binding.closeIcon

        setContentView(binding.root)

        val userNameValue = intent.getStringExtra(ScreensParams.USER_NAME)

        userName.text = userNameValue.toString()

        featuresList.forEachIndexed { index, it -> creteElement(index, it.name) }
        closeButton.setOnClickListener { closeActivity() }
    }

    private fun creteElement(index: Int, text: String) {
        val textView = TextView(this)
        textView.text = "${index + 1}. $text"
        textView.textSize = 32f
        textView.setOnClickListener { handleClickOnElement(text) }

        list.addView(textView)
    }

    private fun handleClickOnElement(title: String) {
        selectedFeature = title
    }

    private fun closeActivity() {
        val intent = Intent()
        intent.putExtra(ScreensParams.CURRENT_FEATURE, selectedFeature)
        val result_status = if (selectedFeature != null) RESULT_OK else RESULT_CANCELED
        setResult(result_status, intent)
        finish()
    }
}