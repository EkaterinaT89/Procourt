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
import ru.procourt.databinding.FragmentAddCommentBinding
import ru.procourt.databinding.FragmentCardCommentBinding
import ru.procourt.databinding.FragmentCardNewsBinding
import ru.procourt.dto.Comment
import ru.procourt.dto.News

class CommentAdapter() :
    ListAdapter<Comment, CommentViewHolder>(CommentDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val binding =
            FragmentCardCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = getItem(position)
        holder.bind(comment)
    }

}

class CommentViewHolder(
    private val binding: FragmentCardCommentBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(comment: Comment) {

        binding.apply {
            fccAuthorName.text = comment.author
            fccComment.text = comment.commentContent
            fccCommentTime.text = comment.date

        }

    }
}


class CommentDiffCallback : DiffUtil.ItemCallback<Comment>() {
    override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean {
        return oldItem == newItem
    }
}