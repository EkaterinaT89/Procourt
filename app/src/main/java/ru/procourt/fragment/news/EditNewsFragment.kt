package ru.procourt.fragment.news

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.databinding.FragmentEditNewsBinding

@SuppressLint("ClickableViewAccessibility")
class EditNewsFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentEditNewsBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fenAddVideoButton.setOnClickListener {
                fenAddVideoButton.visibility = View.INVISIBLE
                fenAddVideoGroup.visibility = View.VISIBLE
                fenSaveNewsButton.visibility = View.VISIBLE
                fenAddVideoButtonMinus.visibility = View.VISIBLE
            }
            fenAddVideoButtonMinus.setOnClickListener {
                fenAddVideoButton.visibility = View.VISIBLE
                fenAddVideoGroup.visibility = View.GONE
                fenSaveNewsButton.visibility = View.GONE
                fenAddVideoButtonMinus.visibility = View.GONE
            }

            fenAddPhotoButton.setOnClickListener {
                fenAddPhotoButton.visibility = View.GONE
                addPhotoVisibility.visibility = View.VISIBLE
                fenCreateNews.visibility = View.GONE
            }
            fenAddPhotoButtonMinus.setOnClickListener {
                fenAddPhotoButton.visibility = View.VISIBLE
                addPhotoVisibility.visibility = View.GONE
                fenCreateNews.visibility = View.VISIBLE
            }
            fenSaveNewsButton.setOnClickListener {
                findNavController().navigate(R.id.newsFragment)
            }
            fenSaveNewsButtonMinus.setOnClickListener {
                findNavController().navigate(R.id.newsFragment)
            }
            fenPickPhoto.setOnClickListener {

            }

            fen.setOnTouchListener { _, motionEvent ->
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