package ru.procourt.fragment.news

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.databinding.FragmentAddNewsBinding

@SuppressLint("ClickableViewAccessibility")
class AddNewsFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentAddNewsBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fanAddVideoButton.setOnClickListener {
                fanAddVideoButton.visibility = View.INVISIBLE
                fanAddVideoGroup.visibility = View.VISIBLE
                fanSaveNewsButton.visibility = View.VISIBLE
                fanAddVideoButtonMinus.visibility = View.VISIBLE
            }
            fanAddVideoButtonMinus.setOnClickListener {
                fanAddVideoButton.visibility = View.VISIBLE
                fanAddVideoGroup.visibility = View.GONE
                fanSaveNewsButton.visibility = View.GONE
                fanAddVideoButtonMinus.visibility = View.GONE
            }

            fanAddPhotoButton.setOnClickListener {
                fanAddPhotoButton.visibility = View.GONE
                addPhotoVisibility.visibility = View.VISIBLE
                fanCreateNews.visibility = View.GONE
            }
            fanAddPhotoButtonMinus.setOnClickListener {
                fanAddPhotoButton.visibility = View.VISIBLE
                addPhotoVisibility.visibility = View.GONE
                fanCreateNews.visibility = View.VISIBLE
            }
            fanSaveNewsButton.setOnClickListener {
                findNavController().navigate(R.id.newsFragment)
            }
            fanSaveNewsButtonMinus.setOnClickListener {
                findNavController().navigate(R.id.newsFragment)
            }
            fanPickPhoto.setOnClickListener {

            }

            fan.setOnTouchListener { _, motionEvent ->
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN -> {
                        findNavController().navigate(R.id.newsFragment)
                    }
                }
                true
            }

        }

        return binding.root
    }

}