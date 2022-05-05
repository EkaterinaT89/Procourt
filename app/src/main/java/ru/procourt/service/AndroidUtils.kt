package ru.procourt.service

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlin.math.ceil

class AndroidUtils {
    fun hideKeyboard(view: View) {
        val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun dp(context: Context, dp: Float): Int {
        return if (dp == 0F) 0 else ceil(
            context.resources.displayMetrics.density * dp
        ).toInt()
    }
}