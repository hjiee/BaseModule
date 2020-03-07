package com.hyden.ext

import android.content.Context
import android.provider.Settings
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast


fun Context.showKeyboard(view: View) {
    view.apply {
        when (view) {
            is EditText -> {
                isFocusable = true
                isFocusableInTouchMode = true
                requestFocus()
                (getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)?.showSoftInput(
                    this,
                    InputMethodManager.SHOW_IMPLICIT
                )
                view.setSelection(view.length())
            }
        }
    }
}

fun Context.hideKeyboard(view: View) {
    (getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)?.hideSoftInputFromWindow(
        view.windowToken,
        0
    )
}

fun Context.checkPermission(neededPermissions: List<String>): Boolean {
    return true
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.isTimeAutomatic(): Boolean {
    return Settings.System.getInt(contentResolver, Settings.System.AUTO_TIME, 0) == 0
}