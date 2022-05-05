package ru.procourt.fragment.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.databinding.FragmentIntroAuthChooseBinding

class IntroChooseAuthFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentIntroAuthChooseBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fiacBackButton.setOnClickListener {
                findNavController().navigate(R.id.introEmailAuthFragment)
            }
        }

        return binding.root
    }

}