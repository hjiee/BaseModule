package com.hyden.ext

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter(value = ["dateFormat"], requireAll = false)
fun TextView.dateFormat(date : Date) {
    val sdf = SimpleDateFormat("yyyy.MM.dd HH:mm:ss")
    val formDate = sdf.format(date).toString()
    text = formDate
}

@BindingAdapter(value = ["likeCount"], requireAll = false)
fun TextView.likeCount(count : Long) {
    text = count.toString()
}