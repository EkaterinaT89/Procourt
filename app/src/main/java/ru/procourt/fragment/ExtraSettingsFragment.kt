package ru.procourt.fragment
//
//import android.annotation.SuppressLint
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.MotionEvent
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.navigation.fragment.findNavController
//import ru.procourt.R
//import ru.procourt.databinding.FragmentExtraSettingsBinding
//
//class ExtraSettingsFragment: Fragment() {
//
//    @SuppressLint("ClickableViewAccessibility")
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//
//        val binding = FragmentExtraSettingsBinding.inflate(
//            inflater,
//            container,
//            false
//        )
//
//        with(binding) {
//            extraSet.setOnTouchListener { _, motionEvent ->
//                when (motionEvent.action) {
//                    MotionEvent.ACTION_DOWN -> {
//                        findNavController().navigate(R.id.settingsFragment)
//                    }
//                }
//                true
//            }
//
//        }
//
//        return binding.root
//    }
//
//}