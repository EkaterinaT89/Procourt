package ru.procourt.fragment.search

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.gms.dynamic.SupportFragmentWrapper
import ru.procourt.R
import ru.procourt.databinding.FragmentFiltrCourtSearchBinding

class FiltrCourtSearchFragment: Fragment() {

    @SuppressLint("ClickableViewAccessibility", "UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentFiltrCourtSearchBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            ffcrsRentTitle.setOnClickListener {
                context?.let { it1 ->
                    AlertDialog.Builder(it1)
                        .setTitle("            Арендовать корт")
                        .setMessage(R.string.rent_court_info)
                        .setNegativeButton("Закрыть") { dialogInterface, i ->
                            return@setNegativeButton
                        }
                        .setNeutralButton("                         ") { dialogInterface, i ->

                        }
                        .show()
                }
            }
            ffcrs.setOnTouchListener { _, motionEvent ->
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN -> {
                        findNavController().navigate(R.id.searchFragment)
                    }
                }
                true
            }

            ffcrsChooseDateButton.setOnClickListener {
//                календарь!!!
            }
        }

        return binding.root
    }

}