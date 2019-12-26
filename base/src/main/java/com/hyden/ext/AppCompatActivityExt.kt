package com.hyden.ext

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.hyden.base.R

fun AppCompatActivity.replaceFragment(fragment : Fragment, layoutId : Int) {
    supportFragmentManager.beginTransaction()
        .setCustomAnimations(R.anim.fade_in,R.anim.fade_out)
        .replace(layoutId,fragment)
        .commitNow()
}

fun AppCompatActivity.moveToActivity(intent : Intent) {
    startActivity(intent)
    overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
}

fun AppCompatActivity.moveToActivityForResult(intent : Intent) {
    val BOOK_NOTE_REQUEST_CODE = 1224
    startActivityForResult(intent,BOOK_NOTE_REQUEST_CODE)
    overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
}

