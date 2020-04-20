package com.hyden.base

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding

class BaseItemsApdater(
    val layoutId: Int,
    val bindingVariableId: Int? = -1
) : BaseRecyclerView.Adapter<Any, ViewDataBinding>(
    layoutId = layoutId,
    bindingVariableId = bindingVariableId

) {

    private val items = mutableListOf<Any>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerView.ViewHolder<ViewDataBinding> {
        return super.onCreateViewHolder(parent, viewType)
    }

    override fun getItemCount(): Int {
        return super.getItemCount()
    }

    override fun onBindViewHolder(
        holder: BaseRecyclerView.ViewHolder<ViewDataBinding>,
        position: Int
    ) {
        super.onBindViewHolder(holder, position)
    }

    fun addItems(items : List<Any>) {

    }
}