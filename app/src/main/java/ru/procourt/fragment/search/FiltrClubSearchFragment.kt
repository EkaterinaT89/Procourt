package ru.procourt.fragment.search

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.databinding.FragmentFiltrClubSearchBinding
import ru.procourt.databinding.FragmentFiltrTournamentChildBinding

class FiltrClubSearchFragment : Fragment() {

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentFiltrClubSearchBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            ffcs.setOnTouchListener { _, motionEvent ->
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN -> {
                        findNavController().navigate(R.id.searchFragment)
                    }
                }
                true
            }

        }

        return binding.root
    }
}