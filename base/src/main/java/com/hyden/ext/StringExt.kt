package com.hyden.ext

import java.text.DecimalFormat
import java.text.NumberFormat


fun String.numberFormatter() : String {
    return DecimalFormat("#,###").let {
        it.format(this.toDouble())
    }
}
