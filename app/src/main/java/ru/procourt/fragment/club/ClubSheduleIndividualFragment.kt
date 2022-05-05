package ru.procourt.fragment.club

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.procourt.databinding.FragmentSheduleIndividualClubBinding
import ru.procourt.databinding.FragmentSheduleRentClubBinding

class ClubSheduleIndividualFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentSheduleIndividualClubBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fsicopenSheduleFirstCourt.setOnClickListener {
                fsicFirstCourtCouchesContainer.visibility = View.VISIBLE
                fsicFirstCourtSheduleContainer.visibility = View.VISIBLE
                fsicFirstCourtChooseCouch.visibility = View.VISIBLE
                fsicFirstCourtChooseCouchArrowButton.visibility = View.VISIBLE
            }
            fsicOpenSheduleSecondCourt.setOnClickListener {
                fsicSecondCourtCouchesContainer.visibility = View.VISIBLE
                fsicSecondCourtSheduleContainer.visibility = View.VISIBLE
                fsicSecondCourtChooseCouch.visibility = View.VISIBLE
                fsicSecondCourtChooseCouchArrowButton.visibility = View.VISIBLE
            }
            fsicOpenSheduleThirdCourt.setOnClickListener {
                fsicThirdCourtCouchesContainer.visibility = View.VISIBLE
                fsicThirdCourtSheduleContainer.visibility = View.VISIBLE
                fsicThirdCourtChooseCouch.visibility = View.VISIBLE
                fsicThirdCourtChooseCouchArrowButton.visibility = View.VISIBLE
            }
            fsicOpenSheduleFourthCourt.setOnClickListener {
                fsicFourthCourtCouchesContainer.visibility = View.VISIBLE
                fsicFourthSheduleContainer.visibility = View.VISIBLE
                fsicFourthCourtChooseCouch.visibility = View.VISIBLE
                fsicFourthCourtChooseCouchArrowButton.visibility = View.VISIBLE
            }
            fsicLoopEventSwitcher.setOnCheckedChangeListener { buttonView, isChecked ->
                if(isChecked){
                    fsicLoopContainer.visibility = View.VISIBLE
                    fsicCalendarImage.visibility = View.VISIBLE
                    fsicPeriod.visibility = View.VISIBLE
                }else{
                    fsicLoopContainer.visibility = View.GONE
                    fsicCalendarImage.visibility = View.GONE
                    fsicPeriod.visibility = View.GONE
                }
            }
        }

        return binding.root
    }

}