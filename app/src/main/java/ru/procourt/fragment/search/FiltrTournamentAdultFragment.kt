package ru.procourt.fragment.search

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.procourt.R
import ru.procourt.databinding.FragmentFiltrTournamentAdultBinding

class FiltrTournamentAdultFragment: Fragment() {

    @SuppressLint("ClickableViewAccessibility", "UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentFiltrTournamentAdultBinding.inflate(
            inflater,
            container,
            false
        )

        with(binding) {
            fftaLevelTournamentsFemale.setOnClickListener {

            }
            fftaLevelTournamentsMale.setOnClickListener {

            }
            fftaDateButton.setOnClickListener {
//                календарь!!!
            }
            fftaApplyButton.setOnClickListener {

            }
            fftaPartInfoButton.setOnClickListener {
                context?.let { it1 ->
                    AlertDialog.Builder(it1).setTitle("            Участвовать в турнире")
                        .setMessage("Для участия в турнирах необходимо приобрести абонемент. После оплаты вы получаете личный номер дающий право участия в любых турнирах, организованных сервисом Procourt.ru на протяжении всего срока действия абонемента. Для участия в бесплатных турнирах дополнительная плата не требуется. Для участия в турнирах, предусматривающих денежные выплаты победителям может потребоваться дополнительная плата за участие.\n" +
                                "\n" +
                                "Последовательность действий:\n" +
                                "\n" +
                                "1. На странице «Участвовать в турнире» нажмите «Участвовать»\n" +
                                "\u20282. Во всплывающем окне выберите период действия абонемента который вы хотите оплатить.\n" +
                                "\u20283. На странице «Корзина» выберите доступную для Вас форму оплаты, поставьте галочку подтверждающее ваше согласие с Договором-офертой и нажмите «Оформить заказ».")
                        .setNegativeButton("Закрыть") { dialogInterface, i ->
                            return@setNegativeButton
                        }
                        .setNeutralButton("                         ") { dialogInterface, i ->

                        }
                        .show()
                }
            }
            ffta.setOnTouchListener { _, motionEvent ->
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN -> {
                        findNavController().navigate(R.id.searchFragment)
                    }
                }
                true
            }

        }

        return binding.root
    }
}