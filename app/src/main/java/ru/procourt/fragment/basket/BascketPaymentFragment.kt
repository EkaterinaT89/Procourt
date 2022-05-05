package ru.procourt.fragment.basket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.procourt.R
import ru.procourt.databinding.FragmentPaymentBascketBinding

class BascketPaymentFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentPaymentBascketBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            when (fpbPaymentOptions.checkedRadioButtonId) {
                R.id.book_and_pay_cash -> fpbCashPaymentInfo.visibility = View.VISIBLE
                R.id.pay_online -> null
                R.id.fpb_pay_club_account -> fpbClubAccountPaymentInfo.visibility = View.VISIBLE
                else -> {

                }
            }
        }

        return binding.root
    }
}