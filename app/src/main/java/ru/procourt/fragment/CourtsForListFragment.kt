package ru.procourt.fragment
//
//import android.annotation.SuppressLint
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import ru.procourt.R
//import ru.procourt.databinding.CourtsForListBinding
//import ru.procourt.databinding.OneCourtBinding
//
//class CourtsForListFragment: Fragment() {
//
//    @SuppressLint("ResourceAsColor")
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//
//        val binding = OneCourtBinding.inflate(
//            inflater,
//            container,
//            false
//        )
//
//        with(binding) {
//            getCourtButton.setOnClickListener {
//                getCourtButton.setTextColor(R.color.white)
//                getCourtButton.setBackgroundColor(R.color.first_intro_screen)
//            }
//        }
//
//        return binding.root
//    }
//
//}