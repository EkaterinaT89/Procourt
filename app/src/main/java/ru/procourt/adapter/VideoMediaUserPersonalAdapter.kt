package ru.procourt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.procourt.R
import ru.procourt.databinding.*
import ru.procourt.dto.*

class VideoMediaUserPersonalAdapter() :
    ListAdapter<News, VideoMediaUserPersonalViewHolder>(VideoMediaUserPersonalDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoMediaUserPersonalViewHolder {
        val binding =
            MediaPlayerVideoNewsCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoMediaUserPersonalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VideoMediaUserPersonalViewHolder, position: Int) {
        val news = getItem(position)
        holder.bind(news)
    }

}

class VideoMediaUserPersonalViewHolder(
    private val binding: MediaPlayerVideoNewsCardBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(news: News) {
        binding.apply {
            newsTitle.text = news.content
            date.text = news.date
        }
    }
}

class VideoMediaUserPersonalDiffCallback : DiffUtil.ItemCallback<News>() {
    override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem == newItem
    }
}