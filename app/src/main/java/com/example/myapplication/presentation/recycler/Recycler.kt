package com.example.myapplication.presentation.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityRecyclerBinding
import androidx.recyclerview.widget.ConcatAdapter

class Recycler : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        recyclerView = binding.rvList

        val layoutManager = LinearLayoutManager(this)
        val divider = DividerItemDecoration(recyclerView.context, layoutManager.orientation)

        val headerAdapter = HeaderAdapter()
        val contentAdapter = Adapter(data)
        val concatAdapter = ConcatAdapter(headerAdapter, contentAdapter)
        recyclerView.adapter = concatAdapter

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(divider)


        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}