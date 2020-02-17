package com.hyden.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RecyclerItemDecoration(private val space : Int) : RecyclerView.ItemDecoration() {

    // TODO: 2020-02-11 item decoration gridlayout span에 맞게 사이즈 조절

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.left = space
        outRect.right = space
        outRect.top = space
        outRect.bottom = space
    }
}