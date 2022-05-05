package ru.procourt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.procourt.R
import ru.procourt.databinding.*
import ru.procourt.dto.*

class ShedulePlayerPersonalAdapter() :
    ListAdapter<Date, ShedulePlayerPersonalViewHolder>(ShedulePlayerPersonalDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShedulePlayerPersonalViewHolder {
        val binding =
            FragmentCardPlayerPersonalSheduleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShedulePlayerPersonalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShedulePlayerPersonalViewHolder, position: Int) {
        val date = getItem(position)
        holder.bind(date)
    }

}

class ShedulePlayerPersonalViewHolder(
    private val binding: FragmentCardPlayerPersonalSheduleBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(date: Date) {
        binding.apply {
            fcppsDayOfWeek.text = date.dayOfWeek
            fcppsNumder.text = date.number.toString()
            fcppsHour.text = date.hour
        }
    }
}

class ShedulePlayerPersonalDiffCallback : DiffUtil.ItemCallback<Date>() {
    override fun areItemsTheSame(oldItem: Date, newItem: Date): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Date, newItem: Date): Boolean {
        return oldItem == newItem
    }
}