package ru.procourt.fragment.player

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.databinding.FragmentAddNewsMediaPpBinding
import ru.procourt.viewModel.NewsViewModel

class FragmentAddNewsMediaPP: Fragment() {

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentAddNewsMediaPpBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            addNews.setOnTouchListener { _, motionEvent ->
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN -> {
                        findNavController().navigate(R.id.newsMediaPlayerPersonalFragment)
                    }
                }
                true
            }

            saveButton.setOnClickListener {
                findNavController().navigate(R.id.newsMediaPlayerPersonalFragment)
            }
        }

        return binding.root
    }
}