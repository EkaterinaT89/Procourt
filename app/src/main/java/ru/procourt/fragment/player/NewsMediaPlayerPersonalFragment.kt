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
import ru.procourt.databinding.FragmentNewsMediaPlayerPersonalBinding
import ru.procourt.viewModel.NewsViewModel

class NewsMediaPlayerPersonalFragment: Fragment() {

    private val newsViewModel: NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentNewsMediaPlayerPersonalBinding.inflate(
            inflater,
            container,
            false
        )

        val adapter = NewsMediaPlayerPersonalAdapter()

        binding.fnmppContainerForNews.adapter = adapter

        newsViewModel.data.observe(viewLifecycleOwner) { news ->
            adapter.submitList(news)
        }

        with(binding) {
            fnmppAddNews.setOnClickListener {
                findNavController().navigate(R.id.fragmentAddNewsMediaPP)
            }
            fnmppPhoto.setOnClickListener {
                findNavController().navigate(R.id.photoMediaPlayerPersonalFragment)
            }
            fnmppVideo.setOnClickListener {
                findNavController().navigate(R.id.videoMediaPlayerPersonalFragment)
            }

        }

        return binding.root
    }

}