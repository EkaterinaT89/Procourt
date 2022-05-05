package ru.procourt.fragment.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.procourt.R
import ru.procourt.databinding.FragmentCardPlayerSearchBinding

class CardPlayerSearchFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentCardPlayerSearchBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fcpsChoosePlayerTimeButton.setOnClickListener {

            }
        }

        return binding.root
    }

}