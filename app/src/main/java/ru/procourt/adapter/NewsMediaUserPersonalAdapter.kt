package ru.procourt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.procourt.R
import ru.procourt.databinding.*
import ru.procourt.dto.*

class NewsMediaUserPersonalAdapter() :
    ListAdapter<News, NewsMediaUserPersonalViewHolder>(NewsMediaUserPersonalDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsMediaUserPersonalViewHolder {
        val binding =
            FragmentCardNewsMediaPlayerPersonalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsMediaUserPersonalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsMediaUserPersonalViewHolder, position: Int) {
        val news = getItem(position)
        holder.bind(news)
    }

}

class NewsMediaUserPersonalViewHolder(
    private val binding: FragmentCardNewsMediaPlayerPersonalBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(news: News) {
        binding.apply {
            fcnmppNewsTitle.text = news.content
            fcnmppDate.text = news.date
        }
    }
}

class NewsMediaUserPersonalDiffCallback : DiffUtil.ItemCallback<News>() {
    override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem == newItem
    }
}