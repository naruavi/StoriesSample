package com.example.storiessample.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.storiessample.domain.Story
import com.example.storiessample.databinding.StoriesItemBinding

class StoriesAdapter(private val stories: List<Story>, private val onClick: (it: Int) -> Unit): RecyclerView.Adapter<StoriesAdapter.StoriesViewHolder>() {


    class StoriesViewHolder(private val binding: StoriesItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(story: Story) {
            with(binding) {
                val uri = story.Poster.toUri().buildUpon().scheme("https").build()
                Glide.with(profileImage).load(story.Poster).into(profileImage);
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesViewHolder {
        val view = StoriesItemBinding.inflate(LayoutInflater.from(parent.context))
        val holder = StoriesViewHolder(view)
        view.root.setOnClickListener {
            onClick(holder.adapterPosition)
        }
        return holder
    }

    override fun getItemCount(): Int {
        return stories.size
    }

    override fun onBindViewHolder(holder: StoriesViewHolder, position: Int) {
        val story = stories[position]
        holder.bind(story)
    }
}