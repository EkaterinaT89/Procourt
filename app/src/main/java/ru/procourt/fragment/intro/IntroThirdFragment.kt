package ru.procourt.fragment.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.databinding.FragmentIntroThirdBinding

class IntroThirdFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentIntroThirdBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fifBackButton.setOnClickListener {
                findNavController().navigate(R.id.introSecondFragment)
            }
            fifSkipButton.setOnClickListener {
                findNavController().navigate(R.id.newsFragment)
            }
            fifNextButton.setOnClickListener {
                findNavController().navigate(R.id.introGeoFragment)
            }
        }

        return binding.root
    }

}