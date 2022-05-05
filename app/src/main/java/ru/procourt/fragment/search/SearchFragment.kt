package ru.procourt.fragment.search

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import ru.procourt.R
import ru.procourt.adapter.SearchFragmentAdapter
import ru.procourt.databinding.FragmentSearchBinding

class SearchFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentSearchBinding.inflate(
            inflater,
            container,
            false
        )


        with(binding) {
            tabLayout.setSelectedTabIndicatorColor(Color.WHITE)

            // Number Of Tabs
            val numberOfTabs = 4

            // Set Tabs in the center
            tabLayout.tabGravity = TabLayout.GRAVITY_CENTER

            // Show all Tabs in screen
            tabLayout.tabMode = TabLayout.MODE_FIXED

            // Set the ViewPager Adapter
            val adapter = SearchFragmentAdapter(getParentFragmentManager(), lifecycle, numberOfTabs)
            tabsViewpager.adapter = adapter

            // Enable Swipe
            tabsViewpager.isUserInputEnabled = true

            // Link the TabLayout and the ViewPager2 together and Set Text & Icons
            TabLayoutMediator(tabLayout, tabsViewpager) { tab, position ->
                when (position) {
                    0 -> {
                        tab.text = "КЛУБ"
                    }
                    1 -> {
                        tab.text = "КОРТ"
                    }
                    2 -> {
                        tab.text = "ИГРОК"
                    }
                    3 -> {
                        tab.text = "ТУРНИР"
                    }

                }

            }.attach()

        }

        return binding.root
    }

}