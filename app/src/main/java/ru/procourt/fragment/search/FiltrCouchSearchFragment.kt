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
import ru.procourt.databinding.FragmentCoverCardSearchBinding
import ru.procourt.databinding.FragmentFiltrCouchSearchBinding

class FiltrCouchSearchFragment: Fragment() {

    @SuppressLint("UseCompatLoadingForDrawables", "ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentFiltrCouchSearchBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {

            ffcsDateButton.setOnClickListener {
//                календарь!!!
            }
            ffcsApplyButton.setOnClickListener {

            }
            ffcsRentCouchTitle.setOnClickListener {
                context?.let { it1 ->
                    AlertDialog.Builder(it1).setTitle("            Заказать тренера")
                        .setMessage(R.string.couch_info)
                        .setNegativeButton("Закрыть") { dialogInterface, i ->
                            return@setNegativeButton
                        }
                        .setNeutralButton("") { dialogInterface, i ->

                        }
                        .show()
                }
            }
            ffcos.setOnTouchListener { _, motionEvent ->
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