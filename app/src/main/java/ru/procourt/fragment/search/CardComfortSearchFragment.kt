package ru.procourt.fragment.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.procourt.R
import ru.procourt.databinding.FragmentComfortCardSearchBinding

class CardComfortSearchFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentComfortCardSearchBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fcmcsLight.setOnClickListener {
                fcmcsLight.setBackgroundColor(resources.getColor(R.color.yellow))
                fcmcsLight.setTextColor(resources.getColor(R.color.dark_orange))
            }
            fcmcsMassage.setOnClickListener {
                fcmcsLight.setBackgroundColor(resources.getColor(R.color.yellow))
                fcmcsLight.setTextColor(resources.getColor(R.color.dark_orange))
            }
            fcmcsSauna.setOnClickListener {
                fcmcsLight.setBackgroundColor(resources.getColor(R.color.yellow))
                fcmcsLight.setTextColor(resources.getColor(R.color.dark_orange))
            }
            fcmcsShower.setOnClickListener {
                fcmcsLight.setBackgroundColor(resources.getColor(R.color.yellow))
                fcmcsLight.setTextColor(resources.getColor(R.color.dark_orange))
            }

        }

        return binding.root
    }
}