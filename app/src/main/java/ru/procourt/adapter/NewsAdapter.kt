package ru.procourt.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.color.MaterialColors.getColor
import ru.procourt.R
import ru.procourt.databinding.FragmentCardNewsBinding
import ru.procourt.dto.News
import ru.procourt.service.NewsService

interface OnInteractionListener {
    fun onShareVk(news: News)
    fun onShareFb(news: News)
    fun onAddComment(news: News)
    fun onShareOut(news: News)
    fun onEdit(news: News)
}

class NewsAdapter(private val onInteractionListener: OnInteractionListener) :
    ListAdapter<News, NewsViewHolder>(NewsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding =
           FragmentCardNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding, onInteractionListener)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = getItem(position)
        holder.bind(news)
    }

}

class NewsViewHolder(
    private val binding: FragmentCardNewsBinding,
    private val onInteractionListener: OnInteractionListener,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(news: News) {

        binding.apply {

            fcnAuthorName.text = news.author
            fcnContent.text = news.content
            fcnDate.text = news.date
            fcnShareVk.text = NewsService.countPresents(news.shareVkCount)
            fcnShareFb.text = NewsService.countPresents(news.shareFbCount)
            fcnShareOut.text = NewsService.countPresents(news.shareOutCount)
            fcnComments.text = NewsService.countPresents(news.commentCount)

            if (!news.video.isNullOrEmpty()) {
                fcnAttachments.visibility = View.VISIBLE
            } else {
                fcnAttachments.visibility = View.GONE
            }

            if (news.shareFbCount != 0L) {
                fcnShareFb.setIconTintResource(R.color.dark_blue)
            } else {
                fcnShareFb.setIconTintResource(R.color.dark_grey)
            }

            if (news.shareVkCount != 0L) {
                fcnShareVk.setIconTintResource(R.color.dark_blue)
            } else {
                fcnShareVk.setIconTintResource(R.color.dark_grey)
            }

            if (news.shareOutCount != 0L) {
                fcnShareOut.setIconTintResource(R.color.dark_blue)
            } else {
                fcnShareOut.setIconTintResource(R.color.dark_grey)
            }

            if (news.commentCount != 0L) {
                fcnComments.setIconTintResource(R.color.dark_blue)
            } else {
                fcnComments.setIconTintResource(R.color.dark_grey)
            }


            if (news.attachment == null) {
                fcnAttachments.visibility = View.GONE
            } else {
                fcnAttachments.visibility = View.VISIBLE

                fcnShareVk.setOnClickListener {
                    onInteractionListener.onShareVk(news)
                    Log.d("CLICK!!!!", "click")
                }
                fcnShareFb.setOnClickListener {
                    onInteractionListener.onShareFb(news)
                }
                fcnShareOut.setOnClickListener {
                    onInteractionListener.onShareOut(news)
                }
                fcnEditNewsButton.setOnClickListener {
                    onInteractionListener.onEdit(news)
                }
                fcnComments.setOnClickListener {
                    onInteractionListener.onAddComment(news)
                }
                fcnContent.setOnClickListener {
                    onInteractionListener.onAddComment(news)
                }

            }

        }
    }
}

class NewsDiffCallback : DiffUtil.ItemCallback<News>() {
    override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem == newItem
    }
}