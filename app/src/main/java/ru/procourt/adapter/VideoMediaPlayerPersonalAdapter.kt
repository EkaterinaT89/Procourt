package ru.procourt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.procourt.R
import ru.procourt.databinding.*
import ru.procourt.dto.*

class VideoMediaPlayerPersonalAdapter() :
    ListAdapter<News, VideoMediaPlayerPersonalViewHolder>(VideoMediaPlayerPersonalDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoMediaPlayerPersonalViewHolder {
        val binding =
            MediaPlayerVideoNewsCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoMediaPlayerPersonalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VideoMediaPlayerPersonalViewHolder, position: Int) {
        val news = getItem(position)
        holder.bind(news)
    }

}

class VideoMediaPlayerPersonalViewHolder(
    private val binding: MediaPlayerVideoNewsCardBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(news: News) {
        binding.apply {
            newsTitle.text = news.content
            date.text = news.date
        }
    }
}

class VideoMediaPlayerPersonalDiffCallback : DiffUtil.ItemCallback<News>() {
    override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem == newItem
    }
}