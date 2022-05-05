package ru.procourt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.procourt.R
import ru.procourt.databinding.*
import ru.procourt.dto.*

class MediaPlayerAnotherAdapter() :
    ListAdapter<Media, MediaPlayerAnotherViewHolder>(MediaPlayerAnotherDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaPlayerAnotherViewHolder {
        val binding =
            FragmentCardMediaPlayerPersonalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MediaPlayerAnotherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MediaPlayerAnotherViewHolder, position: Int) {
        val media = getItem(position)
        holder.bind(media)
    }

}

class MediaPlayerAnotherViewHolder(
    private val binding: FragmentCardMediaPlayerPersonalBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(media: Media) {
        binding.apply {

        }
    }
}

class MediaPlayerAnotherDiffCallback : DiffUtil.ItemCallback<Media>() {
    override fun areItemsTheSame(oldItem: Media, newItem: Media): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Media, newItem: Media): Boolean {
        return oldItem == newItem
    }
}