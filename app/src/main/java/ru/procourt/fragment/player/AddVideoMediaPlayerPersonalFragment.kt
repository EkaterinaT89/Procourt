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
import ru.procourt.databinding.FragmentAddVideoMediaPlayerPersonalBinding
import ru.procourt.databinding.FragmentVideoMediaPlayerPersonalBinding

class AddVideoMediaPlayerPersonalFragment : Fragment() {

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentAddVideoMediaPlayerPersonalBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            favmppChooseVideoButton.setOnClickListener {
                favmppVideoLoadText.visibility = View.VISIBLE
                favmppVideoLoadProgress.visibility = View.VISIBLE
                favmppChooseVideoButton.visibility = View.GONE
//                логика по прогрессу сохранения файла и кнопка сохранить появляется. А прогресс изчезает
            }
            addVideo.setOnTouchListener { _, motionEvent ->
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN -> {
                        findNavController().navigate(R.id.videoMediaPlayerPersonalFragment)
                    }
                }
                true
            }
        }

        return binding.root
    }

}