package com.example.myapplication.presentation.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityRecyclerBinding

class Recycler : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        recyclerView = binding.rvList

        recyclerView.adapter = Adapter(data)
        recyclerView.layoutManager = LinearLayoutManager(this)


        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}