package ru.procourt.fragment.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.adapter.MediaPlayerPersonalAdapter
import ru.procourt.adapter.NewsMediaPlayerPersonalAdapter
import ru.procourt.adapter.VideoMediaPlayerPersonalAdapter
import ru.procourt.databinding.FragmentVideoMediaPlayerPersonalBinding
import ru.procourt.viewModel.MediaViewModel
import ru.procourt.viewModel.NewsViewModel

class VideoMediaPlayerPersonalFragment: Fragment() {

    private val newsViewModel: NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentVideoMediaPlayerPersonalBinding.inflate(
            inflater,
            container,
            false
        )

        val adapter = VideoMediaPlayerPersonalAdapter()

        binding.fvmppListOfVideoContainer.adapter = adapter

        newsViewModel.data.observe(viewLifecycleOwner) { news ->
            adapter.submitList(news)
        }

        with(binding) {
            fvmppNews.setOnClickListener {
                findNavController().navigate(R.id.newsMediaPlayerPersonalFragment)
            }
            fvmppPhoto.setOnClickListener {
                findNavController().navigate(R.id.photoMediaPlayerPersonalFragment)
            }
            fvmppAddButton.setOnClickListener {
                findNavController().navigate(R.id.addVideoMediaPlayerPersonalFragment)
            }
        }

        return binding.root
    }

}