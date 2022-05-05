package ru.procourt.fragment.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.databinding.FragmentPhotoMediaPlayerPersonalBinding

class PhotoMediaPlayerPersonalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentPhotoMediaPlayerPersonalBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fpmppAddNews.setOnClickListener {
                findNavController().navigate(R.id.addNewPhotoFragment)
            }

            fpmppMyTournamentsAlbumButton.setOnClickListener {
                fpmppMyTournamentsAlbumButton.visibility = View.GONE
                fpmppContainerAlbumTournaments.visibility = View.VISIBLE
            }
            fpmppDownTorButton.setOnClickListener {
                fpmppMyTournamentsAlbumButton.visibility = View.VISIBLE
                fpmppContainerAlbumTournaments.visibility = View.GONE
            }
            fpmppMyTrainsAlbumButton.setOnClickListener {
                fpmppMyTrainsAlbumButton.visibility = View.GONE
                fpmppContainerAlbumTrains.visibility = View.VISIBLE
            }
            fpmppTrainDownButton.setOnClickListener {
                fpmppMyTrainsAlbumButton.visibility = View.VISIBLE
                fpmppContainerAlbumTrains.visibility = View.GONE
            }
            fpmppMyPhotosAlbumButton.setOnClickListener {
                fpmppMyPhotosAlbumButton.visibility = View.GONE
                fpmppContainerAlbumPhotos.visibility = View.VISIBLE
            }
            fpmppPhotoDownButton.setOnClickListener {
                fpmppMyPhotosAlbumButton.visibility = View.VISIBLE
                fpmppContainerAlbumPhotos.visibility = View.GONE
            }
            fpmppBackButton.setOnClickListener {
                findNavController().navigate(R.id.playerPersonalFragment)
            }
            fpmppNews.setOnClickListener {
                findNavController().navigate(R.id.newsMediaPlayerPersonalFragment)
            }
            fpmppVideo.setOnClickListener {
                findNavController().navigate(R.id.videoMediaPlayerPersonalFragment)
            }

        }

        return binding.root
    }

}