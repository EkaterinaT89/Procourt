package ru.procourt.fragment.player

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.databinding.FragmentFeedbackPlayerPersonalBinding

class FeedbackPlayerPersonalFragment: Fragment() {

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentFeedbackPlayerPersonalBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            feedback.setOnTouchListener { _, motionEvent ->
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN -> {
                        findNavController().navigateUp()
                    }
                }
                true
            }
            ffpMessageForInput.setOnClickListener {

            }
            ffpSendButton.setOnClickListener {
                thanksForFeedback.visibility = View.VISIBLE
                topThingAnother.visibility = View.VISIBLE
                topThing.visibility = View.GONE
                background.visibility = View.GONE
            }
            ffpBackToProfileButton.setOnClickListener {
                findNavController().navigateUp()

            }



        }

        return binding.root
    }

}