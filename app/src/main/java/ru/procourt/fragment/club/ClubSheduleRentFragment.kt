package ru.procourt.fragment.club

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.procourt.databinding.FragmentSheduleRentClubBinding

class ClubSheduleRentFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentSheduleRentClubBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fsrcOpenSheduleFirstCourt.setOnClickListener {
                fsrcFirstCourtSheduleContainer.visibility = View.VISIBLE
            }
            fsrcOpenSheduleSecondCourt.setOnClickListener {
                fsrcSecondCourtSheduleContainer.visibility = View.VISIBLE
            }
            fsrcOpenSheduleThirdCourt.setOnClickListener {
                fsrcFirstCourtSheduleContainer.visibility = View.VISIBLE
            }
            fsrcOpenSheduleFirstCourt.setOnClickListener {
                fsrcThirdCourtSheduleContainer.visibility = View.VISIBLE
            }
            fsrcLoopEventSwitcher.setOnCheckedChangeListener { buttonView, isChecked ->
                if(isChecked){
                    fsrcLoopContainer.visibility = View.VISIBLE
                    fsrcCalendarImage.visibility = View.VISIBLE
                    fsrcPeriod.visibility = View.VISIBLE
                }else{
                    fsrcLoopContainer.visibility = View.GONE
                    fsrcCalendarImage.visibility = View.GONE
                    fsrcPeriod.visibility = View.GONE
                }
            }



        }

        return binding.root
    }

}