package ru.procourt.fragment.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.procourt.R
import ru.procourt.databinding.FragmentCardFriendPlayerPersonalBinding
import ru.procourt.databinding.FragmentGamesForConfirmPlayerPersonalBinding

class GamesForConfirmPlayerPersonalFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentGamesForConfirmPlayerPersonalBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fgfcppConfirmScoreButton.setOnClickListener {
                fgfcppConfirmScoreButton.setTextColor(resources.getColor(R.color.dark_blue))
                fgfcppInputScoreButton.setTextColor(resources.getColor(R.color.dark_blue_transparent))
                fgfcppFinishedMatches.setTextColor(resources.getColor(R.color.dark_blue_transparent))
                fgfcppConfirmScoreButton.visibility = View.VISIBLE
                dottedConfirm.visibility = View.VISIBLE
                fgfcppInputScoreButton.visibility = View.GONE
            }
            fgfcppFinishedMatches.setOnClickListener {
                fgfcppConfirmScoreButton.visibility = View.GONE
                dottedConfirm.visibility = View.GONE
                fgfcppConfirmScoreButton.setTextColor(resources.getColor(R.color.dark_blue_transparent))
                fgfcppInputScoreButton.setTextColor(resources.getColor(R.color.dark_blue_transparent))
                fgfcppInputScoreButton.visibility = View.GONE
            }
            fgfcppInfoNeeded.setOnClickListener {
                fgfcppConfirmScoreButton.visibility = View.GONE
                dottedConfirm.visibility = View.GONE
                fgfcppInputScoreButton.visibility = View.VISIBLE
            }
            fgfcppInputScoreButton.setOnClickListener {
//                фрагмент ввести счет поп ап
            }



        }

        return binding.root
    }

}