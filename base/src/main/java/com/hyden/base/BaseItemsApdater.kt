package com.hyden.base

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.hyden.util.ItemClickListener

class BaseItemsApdater(
    private val layoutId: Int,
    private val bindingVariableId: Int? = -1,
    private val clickItemEvent: ItemClickListener? = null
) : BaseRecyclerView.Adapter<Any, ViewDataBinding>(
    layoutId = layoutId,
    bindingVariableId = bindingVariableId,
    clickItemEvent = clickItemEvent
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