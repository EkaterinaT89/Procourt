package ru.procourt.fragment.news

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.databinding.FragmentCardNewsBinding
import ru.procourt.viewModel.NewsViewModel

class CardNewsFragment: Fragment() {

    val newsViewModel: NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentCardNewsBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fcnShareVk.setOnClickListener {

            }
            fcnShareFb.setOnClickListener {

            }
            fcnShareOut.setOnClickListener {

            }
            fcnContent.setOnClickListener {
                findNavController().navigate(R.id.addCommentFragment)
            }
            fcnEditNewsButton.setOnClickListener {
                findNavController().navigate(R.id.editNewsPopUpFragment)
            }

        }

        return binding.root
    }

}