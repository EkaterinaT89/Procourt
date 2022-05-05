package ru.procourt.fragment.notifications

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
import ru.procourt.databinding.FragmentCreateGroupChatBinding
import ru.procourt.databinding.FragmentGroupChatBinding
import ru.procourt.databinding.FragmentIntroZeroBinding
import ru.procourt.dto.Player
import ru.procourt.viewModel.PlayerViewModel

class GroupChatFragment: Fragment() {

    private val groupChatViewModel: PlayerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentGroupChatBinding.inflate(
            inflater,
            container,
            false
        )

        val groupChatAdapter = GroupChatAdapter(object : GroupChatListener {
            override fun onWrite(player: Player) {
                groupChatViewModel.write(player.id)
            }

            override fun onDelete(player: Player) {

            }

        })

        binding.fcgcAddParticipantsContainer.adapter = groupChatAdapter

        groupChatViewModel.data.observe(viewLifecycleOwner) { players ->
            groupChatAdapter.submitList(players)
        }

        with(binding) {
            fcgcBackButton.setOnClickListener {
                findNavController().navigate(R.id.searchFragment)
            }
            fcgcSaveButton.setOnClickListener {
                findNavController().navigate(R.id.chatForGroupFragment)
            }
            fcgcAddParticipantsButton.setOnClickListener {
                findNavController().navigate(R.id.addParticipantsFragment)
            }
            fcgcLeaveChatButton.setOnClickListener {
                context?.let { it1 ->
                    AlertDialog.Builder(it1).setMessage("Уверены?")
                        .setPositiveButton(
                            "Да, покинуть чат"
                        ) { dialogInterface, i ->
//                            AppAuth.getInstance().removeAuth()
//                            findNavController(R.id.nav_host_fragment).navigateUp()
                            findNavController().navigate(R.id.searchFragment)
                        }
                        .setNegativeButton(
                            "Нет, остаться"
                        ) { dialogInterface, i ->
                            return@setNegativeButton
                        }
                        .show()
                }
            }
        }


        return binding.root
    }

}