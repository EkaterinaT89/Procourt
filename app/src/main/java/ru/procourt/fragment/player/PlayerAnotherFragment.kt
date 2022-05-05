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
import ru.procourt.databinding.FragmentPlayerAnotherBinding
import ru.procourt.databinding.FragmentPlayerPersonalBinding
import ru.procourt.dto.Player
import ru.procourt.viewModel.DateViewModel
import ru.procourt.viewModel.MediaViewModel
import ru.procourt.viewModel.PlayerViewModel

@SuppressLint("UseCompatLoadingForDrawables")
class PlayerAnotherFragment: Fragment() {

    val mediaViewModel: MediaViewModel by viewModels()
    val sheduleViewModel: DateViewModel by viewModels()
    val friendsViewModel: PlayerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentPlayerAnotherBinding.inflate(
            inflater,
            container,
            false
        )

        val mediaAdapter = MediaPlayerAnotherAdapter()

        binding.fpaListOfMediaContainer.adapter = mediaAdapter

        mediaViewModel.data.observe(viewLifecycleOwner) { media ->
            mediaAdapter.submitList(media)
        }


        val sheduleAdapter = ShedulePlayerAnotherAdapter()

        binding.fpaListOfShedulesContainer.adapter = sheduleAdapter

        sheduleViewModel.data.observe(viewLifecycleOwner) { shedule ->
            sheduleAdapter.submitList(shedule)
        }


        val friendsAdapter = FriendsPlayerAnotherAdapter(object: FriendsPlayerAnotherlListener {
            override fun onWrite(player: Player) {
                friendsViewModel.write(player.id)
                findNavController().navigate(R.id.chatFragment)
            }

        })

        binding.fpaListOfFriendsContainer.adapter = friendsAdapter

        friendsViewModel.data.observe(viewLifecycleOwner) { friends ->
            friendsAdapter.submitList(friends)
        }

        with(binding) {
            fpaLicenceAgreement.setOnClickListener {
                context?.let { it1 ->
                    AlertDialog.Builder(it1).setMessage(R.string.licence_agreement)
                        .setPositiveButton(" ") { dialogInterface, i ->

                        }
                        .setNegativeButton(" закрыть"
                        ) { dialogInterface, i ->
                            return@setNegativeButton
                        }
                        .show()
                }
            }
            fpaConfidentialAgreement.setOnClickListener {
                context?.let { it1 ->
                    AlertDialog.Builder(it1).setMessage(R.string.confidential_agreement)
                        .setPositiveButton(" ") { dialogInterface, i ->

                        }
                        .setNegativeButton(" закрыть"
                        ) { dialogInterface, i ->
                            return@setNegativeButton
                        }
                        .show()
                }
            }
            fpaFeedback.setOnClickListener {
                findNavController().navigate(R.id.feedbackPlayerPersonalFragment)
            }
            fpaAddToFriends.setOnClickListener {
                fpaAddToFriends.visibility = View.GONE
                fpaUnfriends.visibility = View.VISIBLE
            }
            fpaUnfriends.setOnClickListener {
                fpaAddToFriends.visibility = View.VISIBLE
                fpaUnfriends.visibility = View.GONE
            }
            fpaChat.setOnClickListener {
                findNavController().navigate(R.id.chatFragment)
            }
            fpaBackButton.setOnClickListener {
                findNavController().navigateUp()
            }
            fpaSheduleButton.setOnClickListener {
                findNavController().navigate(R.id.shedulePlayerAnotherFragment)
            }

        }

        return binding.root
    }

}