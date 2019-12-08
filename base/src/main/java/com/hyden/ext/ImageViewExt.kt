package com.hyden.ext

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.request.RequestOptions
import com.hyden.util.ImageTransformType
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

//@BindingAdapter(value = ["loadUrl"])
//fun ImageView.loadUrl(url: String?) {
//    url?.let {
//        Glide.with(this)
//            .load(it)
//            .override(450,650)
//            .apply(RequestOptions.fitCenterTransform().centerCrop())
//            .into(this)
//    }
//}
@BindingAdapter(value = ["loadUrl", "tranformType"], requireAll = false)
fun ImageView.loadUrl(
    url: String?,
    type: ImageTransformType? = null
) {
    url?.let {
        val multiTransformation = MultiTransformation<Bitmap>(
            RoundedCornersTransformation(14, 0)
        )
        val imageRequestBulider = Glide.with(this)
            .load(it)

        imageRequestBulider.apply {
            when (type) {
                ImageTransformType.ROUND -> {
                    apply(RequestOptions.bitmapTransform(multiTransformation))
                }
                ImageTransformType.FIT -> {
                    override(450, 650)
                    apply(RequestOptions.fitCenterTransform().centerCrop())
                }
                else -> apply(RequestOptions.fitCenterTransform().centerCrop())
            }

        }.let { it.into(this) }
    }
}