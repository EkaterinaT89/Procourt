package ru.procourt.fragment.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.procourt.databinding.FragmentCardOneCourtSearchBinding

class CardOneCourtSearchFragent: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentCardOneCourtSearchBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fcocsExpandCourtsButton.setOnClickListener {
                fcocsExpandCourtsButton.visibility = View.GONE
                fcocsExpandGroup.visibility = View.VISIBLE
            }

            fcocsAutoBookOnOff.setOnClickListener {
                fcocsGroupForAutoBook.visibility = View.VISIBLE
            }

            fcocsCloseCourtsButtonExpand.setOnClickListener {
                fcocsExpandGroup.visibility = View.GONE
            }

        }

        return binding.root
    }

}