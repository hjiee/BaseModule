package com.hyden.ext

import java.text.DecimalFormat
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*


fun String.numberFormatter() : String {
    return DecimalFormat("#,###").let {
        it.format(this.toDouble())
    }
}
