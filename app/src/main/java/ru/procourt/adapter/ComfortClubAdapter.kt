package ru.procourt.adapter

import android.annotation.SuppressLint
import android.icu.util.TimeUnit.values
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.common.config.GservicesValue.value
import ru.procourt.R
import ru.procourt.databinding.FragmentCardCouchForCouchesClubBinding
import ru.procourt.databinding.FragmentComfortCardClubBinding
import ru.procourt.dto.Club
import ru.procourt.dto.Couch

class ComfortClubAdapter():
    ListAdapter<Club, ComfortClubViewHolder>(ComfortClubDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComfortClubViewHolder {
        val binding =
            FragmentComfortCardClubBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ComfortClubViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ComfortClubViewHolder, position: Int) {
        val club = getItem(position)
        holder.bind(club)
    }

}

class ComfortClubViewHolder(
    private val binding: FragmentComfortCardClubBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(club: Club) {

        binding.apply {
            if(club.hasShower == true) {
                fcHasShower.visibility = View.VISIBLE
                fcShower.visibility = View.GONE
            } else {
                fcHasShower.visibility = View.GONE
                fcShower.visibility = View.VISIBLE
            }

            if(club.hasSauna == true) {
                fcHasSauna.visibility = View.VISIBLE
                fcSauna.visibility = View.GONE
            } else {
                fcHasSauna.visibility = View.GONE
                fcSauna.visibility = View.VISIBLE
            }

            if(club.hasMassage == true) {
                fcHasMassage.visibility = View.VISIBLE
                fcMassage.visibility = View.GONE
            } else {
                fcHasMassage.visibility = View.GONE
                fcMassage.visibility = View.VISIBLE
            }

            if(club.hasLight == true) {
                fcHasLight.visibility = View.VISIBLE
                fcLight.visibility = View.GONE
            } else {
                fcHasLight.visibility = View.GONE
                fcLight.visibility = View.VISIBLE
            }

        }

    }
}

class ComfortClubDiffCallback : DiffUtil.ItemCallback<Club>() {
    override fun areItemsTheSame(oldItem: Club, newItem: Club): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Club, newItem: Club): Boolean {
        return oldItem == newItem
    }
}