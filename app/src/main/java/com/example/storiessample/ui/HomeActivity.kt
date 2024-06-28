package com.example.storiessample.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.storiessample.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModels<StoriesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.storiesList.addItemDecoration(MarginItemDecoration(8))
        viewModel.stories.observe(this) {
            Log.d(HomeActivity::class.simpleName, it.toString())
            binding.storiesList.layoutManager =
                LinearLayoutManager(this@HomeActivity, RecyclerView.HORIZONTAL, false)
            binding.storiesList.adapter = StoriesAdapter(it) {
                //start new activity
                val intent = Intent(this@HomeActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }
        viewModel.fetchStories()
    }
}