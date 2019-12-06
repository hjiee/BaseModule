package com.hyden.ext

import android.content.Intent
import androidx.fragment.app.Fragment
import com.hyden.base.R

fun Fragment.replaceFragment(fragment: Fragment, layoutId : Int) {
    fragmentManager?.beginTransaction()
        ?.replace(layoutId,fragment)
        ?.commitNow()
}


fun Fragment.replaceFragmentStack(fragment: Fragment, layoutId : Int) {
    fragmentManager?.beginTransaction()
        ?.replace(layoutId,fragment)
        ?.addToBackStack(null)
        ?.commit()
}


fun Fragment.moveToActivity(intent : Intent) {
    startActivity(intent)
    activity?.overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
}