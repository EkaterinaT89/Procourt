package ru.procourt.fragment.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.procourt.R
import ru.procourt.databinding.FragmentComfortCardSearchBinding
import ru.procourt.databinding.FragmentCoverCardSearchBinding

class CardCoverSearchFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentCoverCardSearchBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fcovcsGreen.setOnClickListener {
                fcovcsGreen.setBackgroundColor(resources.getColor(R.color.yellow))
                fcovcsGreen.setTextColor(resources.getColor(R.color.dark_orange))
            }
            fcovcsHard.setOnClickListener {
                fcovcsHard.setBackgroundColor(resources.getColor(R.color.yellow))
                fcovcsHard.setTextColor(resources.getColor(R.color.dark_orange))
            }
            fcovcsLand.setOnClickListener {
                fcovcsLand.setBackgroundColor(resources.getColor(R.color.yellow))
                fcovcsLand.setTextColor(resources.getColor(R.color.dark_orange))
            }
            fcovcsParket.setOnClickListener {
                fcovcsParket.setBackgroundColor(resources.getColor(R.color.yellow))
                fcovcsParket.setTextColor(resources.getColor(R.color.dark_orange))
            }
            fcovcsRubber.setOnClickListener {
                fcovcsRubber.setBackgroundColor(resources.getColor(R.color.yellow))
                fcovcsRubber.setTextColor(resources.getColor(R.color.dark_orange))
            }

        }

        return binding.root
    }
}