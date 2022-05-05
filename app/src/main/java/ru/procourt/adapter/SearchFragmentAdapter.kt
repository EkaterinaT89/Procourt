package ru.procourt.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.procourt.fragment.search.*

class SearchFragmentAdapter(fm: FragmentManager, lifecycle: Lifecycle, private var numberOfTabs: Int) : FragmentStateAdapter(fm, lifecycle) {

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                // # Клубы
                val bundle = Bundle()
//                bundle.putString("fragmentName", "Music Fragment")
                val clubFragment = ClubSearchFragment()
                clubFragment.arguments = bundle
                return clubFragment
            }
            1 -> {
                // # Корты
                val bundle = Bundle()
//                bundle.putString("fragmentName", "Movies Fragment")
                val courtsFragment = CourtSearchFragment()
                courtsFragment.arguments = bundle
                return courtsFragment
            }
            2 -> {
                // # Игрок
                val bundle = Bundle()
//                bundle.putString("fragmentName", "Books Fragment")
                val playerFragment = PlayerSearchFragment()
                playerFragment.arguments = bundle
                return playerFragment
            }
            3 -> {
                // # Турнир
                val bundle = Bundle()
//                bundle.putString("fragmentName", "Books Fragment")
                val tournamentFragment = TournamentsSearchFragment()
                tournamentFragment.arguments = bundle
                return tournamentFragment
            }
            else -> return SearchFragment()
        }

    }

    override fun getItemCount(): Int {
        return numberOfTabs
    }
}