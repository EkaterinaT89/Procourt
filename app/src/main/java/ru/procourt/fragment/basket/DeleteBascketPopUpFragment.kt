package ru.procourt.fragment.basket

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.databinding.FragmentBascketBinding
import ru.procourt.databinding.FragmentDeleteBascketPopUpBinding

class DeleteBascketPopUpFragment: Fragment() {

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentDeleteBascketPopUpBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fdbpuDeleteFragment.setOnTouchListener { _, motionEvent ->
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN -> {
                        findNavController().navigate(R.id.bascketFragment)
                    }
                }
                true
            }
        }

        return binding.root
    }
}