package ru.procourt.fragment.player

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.adapter.*
import ru.procourt.databinding.FragmentPlayerPersonalBinding
import ru.procourt.dto.Player
import ru.procourt.viewModel.*

@SuppressLint("UseCompatLoadingForDrawables")
class PlayerPersonalFragment : Fragment() {

    val mediaViewModel: MediaViewModel by viewModels()
    val sheduleViewModel: DateViewModel by viewModels()
    val friendsViewModel: PlayerViewModel by viewModels()
    val tournamentViewModel: TournamentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentPlayerPersonalBinding.inflate(
            inflater,
            container,
            false
        )

        val mediaAdapter = MediaPlayerPersonalAdapter()

        binding.fppListOfMediaContainer.adapter = mediaAdapter

        mediaViewModel.data.observe(viewLifecycleOwner) { media ->
            mediaAdapter.submitList(media)
        }


        val sheduleAdapter = ShedulePlayerPersonalAdapter()

        binding.fppListOfShedulesContainer.adapter = sheduleAdapter

        sheduleViewModel.data.observe(viewLifecycleOwner) { shedule ->
            sheduleAdapter.submitList(shedule)
        }


        val friendsAdapter = FriendsPlayerPersonalAdapter(object : FriendsPlayerPersonalListener {
            override fun onWrite(player: Player) {
                friendsViewModel.write(player.id)
                findNavController().navigate(R.id.chatFragment)
            }

        })


        binding.fppListOfFriendsContainer.adapter = friendsAdapter

        friendsViewModel.data.observe(viewLifecycleOwner) { friends ->
            friendsAdapter.submitList(friends)
        }

    val tournamentAdapter = TournamentPlayerPersonalAdapter()

    binding.fppListOfTournamentsContainer.adapter = tournamentAdapter

    tournamentViewModel.data .observe(viewLifecycleOwner)
    {
        tournaments ->
        tournamentAdapter.submitList(tournaments)
    }

    with(binding)
    {
        fppLicenceAgreement.setOnClickListener {
            context?.let { it1 ->
                AlertDialog.Builder(it1).setMessage(R.string.licence_agreement)
                    .setPositiveButton(" ") { dialogInterface, i ->

                    }
                    .setNegativeButton(
                        "Закрыть"
                    ) { dialogInterface, i ->
                        return@setNegativeButton
                    }
                    .show()
            }
        }
        fppConfidentialAgreement.setOnClickListener {
            context?.let { it1 ->
                AlertDialog.Builder(it1).setMessage(R.string.confidential_agreement)
                    .setPositiveButton(" ") { dialogInterface, i ->

                    }
                    .setNegativeButton(
                        "Закрыть"
                    ) { dialogInterface, i ->
                        return@setNegativeButton
                    }
                    .show()
            }
        }
        fppFeedback.setOnClickListener {
            findNavController().navigate(R.id.feedbackPlayerPersonalFragment)
        }
        fppEditProfileButton.setOnClickListener {
            findNavController().navigate(R.id.editPlayerPersonalFragment)
        }
        fppMedia.setOnClickListener {
            findNavController().navigate(R.id.newsMediaPlayerPersonalFragment)
        }
        fppSheduleButton.setOnClickListener {
            findNavController().navigate(R.id.shedulePlayerPersonalFragment)
        }
        fppStatistics.setOnClickListener {
            findNavController().navigate(R.id.gamesPersonalPlayerFragment)
        }
    }

    return binding.root
}

}