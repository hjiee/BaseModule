package com.hyden.ext

import android.content.Context
import android.hardware.input.InputManager
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

fun Context.showKeyboard(view: View) {
    view.apply {
        when(view) {
            is EditText -> {
                isFocusable = true
                isFocusableInTouchMode = true
                requestFocus()
                (getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)?.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
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

fun Context.checkPermission(neededPermissions : List<String>) : Boolean {
    return true
}