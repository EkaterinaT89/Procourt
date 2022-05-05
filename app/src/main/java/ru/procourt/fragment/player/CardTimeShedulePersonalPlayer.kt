package ru.procourt.fragment.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.procourt.R
import ru.procourt.databinding.FragmentCardTimeShedulePersonalPlayerBinding

class CardTimeShedulePersonalPlayer: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentCardTimeShedulePersonalPlayerBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fctsppTimeButton.setOnClickListener {
                fctsppTimeBackground.setBackgroundColor(resources.getColor(R.color.dark_blue))
                fctsppTimeButton.setTextColor(resources.getColor(R.color.white))
                fctsppPrice.setTextColor(resources.getColor(R.color.white))
            }
        }

        return binding.root
    }

}