package com.hyden.ext

import android.graphics.Bitmap
import android.transition.Transition
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.hyden.base.R
import com.hyden.util.ImageTransformType
import jp.wasabeef.glide.transformations.BitmapTransformation
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
            CenterCrop(),
            FitCenter(),
            RoundedCornersTransformation(20, 0)
        )
        val imageRequestBulider = Glide.with(this)
            .load(it)
            .error(R.drawable.book)


        imageRequestBulider.apply {
            when (type) {
                ImageTransformType.ROUND -> {
                    transition(DrawableTransitionOptions.withCrossFade(2000))
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