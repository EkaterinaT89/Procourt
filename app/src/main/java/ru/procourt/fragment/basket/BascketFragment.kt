package ru.procourt.fragment.basket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.procourt.R
import ru.procourt.databinding.FragmentBascketBinding

class BascketFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentBascketBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            badgeDrawable(R.id.search, fbBottomNav)
            badgeDrawable(R.id.person, fbBottomNav)
            badgeDrawable(R.id.notifications, fbBottomNav)

            fbPayButtonForShortText.setOnClickListener {
                findNavController().navigate(R.id.bascketPaymentFragment)
            }

            fbPayButtonForFullText.setOnClickListener {
                findNavController().navigate(R.id.bascketPaymentFragment)
            }

            fbExpandButton.setOnClickListener {
                fbGroupForExpandView.visibility = View.VISIBLE
                fbExpandButton.visibility = View.GONE
                fbExpandButtonBack.visibility = View.VISIBLE
            }

            fbExpandButtonBack.setOnClickListener {
                fbExpandButtonBack.visibility = View.GONE
                fbGroupForExpandView.visibility = View.GONE
                fbExpandButton.visibility = View.VISIBLE
            }
            fbDeleteButtonBasket.setOnClickListener {
                findNavController().navigate(R.id.deleteBascketPopUpFragment)
            }

            fbBottomNav.setOnItemSelectedListener { item ->
                when(item.itemId) {
                    R.id.rectangle -> {
                        findNavController().navigate(R.id.newsFragment)
                        true
                    }
                    R.id.search -> {
                        findNavController().navigate(R.id.searchFragment)
                        true
                    }
                    R.id.notifications -> {
                        findNavController().navigate(R.id.messagesNotificationsFragment)
                        true
                    }
                    R.id.person -> {
                        findNavController().navigate(R.id.playerPersonalFragment)
                        true
                    }

                    else -> false
                }

            }
        }

        return binding.root
    }


    fun badgeDrawable(view: Int, bottomNavigationView: BottomNavigationView) {
        val badgeDrawable = bottomNavigationView.getBadge(view)
        if (badgeDrawable != null) {
            badgeDrawable.isVisible = false
            badgeDrawable.clearNumber()
        }
    }

}