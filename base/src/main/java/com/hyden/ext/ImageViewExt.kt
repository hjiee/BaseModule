package com.hyden.ext

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hyden.util.LogUtil.LogD

@BindingAdapter(value = ["loadUrl"])
fun ImageView.loadUrl(url: String?) {
    url?.let {
        Glide.with(this)
            .load(it)
            .override(450,650)
            .apply(RequestOptions.fitCenterTransform().centerCrop())
            .into(this)
    }
}