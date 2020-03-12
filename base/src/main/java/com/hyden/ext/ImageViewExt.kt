package com.hyden.ext

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.target.SizeReadyCallback
import com.bumptech.glide.request.transition.Transition
import com.hyden.base.R
import com.hyden.util.ImageTransformType
import com.hyden.util.LogUtil.LogW
import com.hyden.util.toPx
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
    url?.let { strUrl ->
        Glide.with(this)
            .load(strUrl)
            .error(R.drawable.book)
            .apply {
                when (type) {
                    ImageTransformType.ROUND -> {
                        val multiTransformation = MultiTransformation<Bitmap>(
                            CenterCrop(),
                            FitCenter(),
                            RoundedCornersTransformation(14f.toPx(context), 0)
                        )
                        transition(DrawableTransitionOptions.withCrossFade(2000))
                        apply(RequestOptions.bitmapTransform(multiTransformation))
                    }
                    ImageTransformType.FIT -> {
//                        override(450, 650)
                        val multiTransformation = MultiTransformation<Bitmap>(
                            CenterCrop(),
                            FitCenter()
                        )
//                        apply(RequestOptions.fitCenterTransform().centerCrop())
                        apply(RequestOptions.bitmapTransform(multiTransformation))
                    }
                    ImageTransformType.CIRCLE -> {
                        thumbnail(0.5f)
                        apply(RequestOptions.circleCropTransform())

                    }
                    else -> apply(RequestOptions.fitCenterTransform().centerCrop())
                }

            }.into(this)
    }

}