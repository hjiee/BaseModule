package com.hyden.ext

import java.text.SimpleDateFormat
import java.util.*

fun Date.toDateFormat() : String {
    val sdf = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
    val date = sdf.format(this).toString()
    return date
}