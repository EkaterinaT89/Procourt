package ru.procourt.fragment.notifications

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.adapter.AddParticipsntaToGroupChatAdapter
import ru.procourt.adapter.AddParticipsntaToGroupChatListener
import ru.procourt.adapter.GroupChatAdapter
import ru.procourt.adapter.GroupChatListener
import ru.procourt.databinding.FragmentAddParticipantsBinding
import ru.procourt.databinding.FragmentChatForGroupChatBinding
import ru.procourt.dto.Player
import ru.procourt.viewModel.PlayerViewModel

class AddParticipantsFragment: Fragment() {

    private val groupChatViewModel: PlayerViewModel by viewModels()

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentAddParticipantsBinding.inflate(
            inflater,
            container,
            false
        )

        val groupChatAdapter = AddParticipsntaToGroupChatAdapter(object : AddParticipsntaToGroupChatListener {
            override fun onChoose(player: Player) {

            }

        })

        binding.addPartsContainer.adapter = groupChatAdapter

        groupChatViewModel.data.observe(viewLifecycleOwner) { players ->
            groupChatAdapter.submitList(players)
        }

        with(binding) {
            fap.setOnTouchListener { _, motionEvent ->
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN -> {
                        findNavController().navigate(R.id.createGroupChatFragment)
                    }
                }
                true
            }
        }


        return binding.root
    }

}