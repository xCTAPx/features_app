package com.example.myapplication.presentation.multithreading

import android.os.Handler
import android.os.Looper
import android.widget.TextView

class MyHandler(val textView: TextView, val msg: String = "Default new message") : Handler(Looper.getMainLooper()) {
    fun handleMessage() {
        this.post {
            textView.setText(msg)
        }
    }
}

class MyThread(val textView: TextView) : Thread() {
    override fun run() {
        val handler = MyHandler(textView, "This is new message")
        sleep(5000)
        handler.handleMessage()
        super.run()
    }
}