package com.example.myapplication.presentation.multithreading

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.databinding.ActivityMultithreadingBinding
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class Multithreading : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMultithreadingBinding
    private lateinit var text: TextView
    private lateinit var changeTextAsyncButton: Button
    private lateinit var blockMainThreadButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityMultithreadingBinding.inflate(layoutInflater)
        text = viewBinding.multithreadingText
        changeTextAsyncButton = viewBinding.multithreadingButton
        blockMainThreadButton = viewBinding.blockThreadButton

        super.onCreate(savedInstanceState)

        setContentView(viewBinding.root)

        changeTextAsyncButton.setOnClickListener { handleWithMultithreading(text) }
        blockMainThreadButton.setOnClickListener { blockMainThread() }
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }

    private fun blockMainThread() {
        scope.launch {
            while (true) {}
        }
    }

    private fun handleWithMultithreading(textView: TextView) {
        val thread = MyThread(textView)
        thread.start()
    }
}