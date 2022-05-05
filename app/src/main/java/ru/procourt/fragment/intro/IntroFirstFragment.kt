package ru.procourt.fragment.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.databinding.FragmentIntroFirstBinding

class IntroFirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentIntroFirstBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fifNextButton.setOnClickListener {
                findNavController().navigate(R.id.introSecondFragment)
            }

            fifSkipButton.setOnClickListener {
//                findNavController().navigate(R.id.newsFragment) должно быть так
                findNavController().navigate(R.id.playerAnotherFragment)
            }
        }

        return binding.root
    }

}