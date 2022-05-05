package ru.procourt.fragment.club

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.adapter.*
import ru.procourt.databinding.FragmentClubBinding
import ru.procourt.dto.Couch
import ru.procourt.dto.Player
import ru.procourt.viewModel.*

class ClubFragment: Fragment() {

    val mediaViewModel: MediaViewModel by viewModels()
    val sheduleViewModel: DateViewModel by viewModels()
    val playerViewModel: PlayerViewModel by viewModels()
    val couchViewModel: CouchViewModel by viewModels()
    val clubViewModel: ClubViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentClubBinding.inflate(
            inflater,
            container,
            false
        )

        val mediaAdapter = MediaPlayerPersonalAdapter()

        binding.fcListOfMediaContainer.adapter = mediaAdapter

        mediaViewModel.data.observe(viewLifecycleOwner) { media ->
            mediaAdapter.submitList(media)
        }


        val sheduleAdapter = ShedulePlayerPersonalAdapter()

        binding.fcListOfShedulesContainer.adapter = sheduleAdapter

        sheduleViewModel.data.observe(viewLifecycleOwner) { shedule ->
            sheduleAdapter.submitList(shedule)
        }

        val playerAdapter = ClubPlayerAdapter(object : ClubPlayerListener {
            override fun onChooseTime(player: Player) {
                playerViewModel.chooseTime(player.id)
            }
        })

        binding.fcListOfPlayersContainer.adapter = playerAdapter

        playerViewModel.data.observe(viewLifecycleOwner) { players ->
            playerAdapter.submitList(players)
        }

        val couchAdapter = CouchClubAdapter(object : CouchClubListener {
            override fun onChooseTime(couch: Couch) {
                couchViewModel.chooseTime(couch.id)
            }
        })

        binding.fcListOfCouchesContainer.adapter = couchAdapter

        couchViewModel.data.observe(viewLifecycleOwner) { couches ->
            couchAdapter.submitList(couches)
        }

        val clubAdapter = ComfortClubAdapter()

        binding.fcListOfComfortsContainer.adapter = clubAdapter

        clubViewModel.data.observe(viewLifecycleOwner) { clubs ->
            clubAdapter.submitList(clubs)
        }

        with(binding) {
            fcSubscribeButton.setOnClickListener {
                fcSubscribeButton.visibility = View.GONE
                fcUnsubscribeButton.visibility = View.VISIBLE
            }
            fcUnsubscribeButton.setOnClickListener {
                fcSubscribeButton.visibility = View.VISIBLE
                fcUnsubscribeButton.visibility = View.GONE
            }
            fcClubChatButton.setOnClickListener {
                findNavController().navigate(R.id.chatFragment)
            }
            fcPlayers.setOnClickListener {
                findNavController().navigate(R.id.clubPlayersFragment)
            }
            fcCouches.setOnClickListener {
                findNavController().navigate(R.id.clubCoushesFragment)
            }
        }

        return binding.root
    }

}