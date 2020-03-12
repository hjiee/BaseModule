package com.hyden.ext

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.provider.Settings
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.hyden.base.R


fun Context.showKeyboard(view: View) {
    view.run {
        when (view) {
            is EditText -> {
                isFocusable = true
                isFocusableInTouchMode = true
                view.requestFocus()
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

fun Context.permissonsCheck(
    neededPermissions: Array<String>,
    granted : (() -> Unit)? = null,
    denied : (() -> Unit)? = null
) {
    for(permission in neededPermissions) {
        if(checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
            denied?.invoke()
            return
        }
    }
    granted?.invoke()
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.showSimpleDialog(
    message: String,
    result: () -> Unit
) {
    AlertDialog.Builder(this, R.style.DeleteDialog).apply {
        setTitle(getString(R.string.app_name))
        setMessage("$message")
        setPositiveButton("확인") { _, _ ->
            result.invoke()
        }
        setNegativeButton("취소") { _, _ ->
        }
    }.show()
}


fun Context.isTimeAutomatic(truth : () -> Unit) {
    if(Settings.Global.getInt(contentResolver, Settings.Global.AUTO_TIME, 0) == 0) {
        showSimpleDialog("시스템시간을 네트워크시간으로 설정하겠습니까?") {
            startActivity(Intent(Settings.ACTION_DATE_SETTINGS))
        }
    } else {
        truth.invoke()
    }

}