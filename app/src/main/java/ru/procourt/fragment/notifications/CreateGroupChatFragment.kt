package ru.procourt.fragment.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.adapter.CreateGroupChatAdapter
import ru.procourt.adapter.CreateGroupChatListener
import ru.procourt.adapter.PlayerSearchAdapter
import ru.procourt.adapter.PlayerSearchListener
import ru.procourt.databinding.FragmentCreateGroupChatBinding
import ru.procourt.databinding.FragmentIntroZeroBinding
import ru.procourt.dto.Player
import ru.procourt.viewModel.PlayerViewModel

class CreateGroupChatFragment: Fragment() {

    private val groupChatViewModel: PlayerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentCreateGroupChatBinding.inflate(
            inflater,
            container,
            false
        )

        val groupChatAdapter = CreateGroupChatAdapter(object : CreateGroupChatListener {
            override fun onWrite(player: Player) {
                groupChatViewModel.write(player.id)
            }

        })

        binding.fcgcAddParticipantsContainer.adapter = groupChatAdapter

        groupChatViewModel.data.observe(viewLifecycleOwner) { players ->
            groupChatAdapter.submitList(players)
        }

        with(binding) {
            fcgcSaveButton.setOnClickListener {
                findNavController().navigate(R.id.groupChatFragment)
            }
            fcgcAddParticipantsButton.setOnClickListener {
                findNavController().navigate(R.id.addParticipantsFragment)
            }
        }


        return binding.root
    }

}