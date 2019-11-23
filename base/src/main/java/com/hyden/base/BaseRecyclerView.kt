package com.hyden.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BaseRecyclerView {
    abstract class Adapter<ITEM : Any, B : ViewDataBinding>(
        private val layoutId: Int,
        private val bindingVariableId: Int?
    ) : RecyclerView.Adapter<ViewHolder<B>>() {


        private var list = listOf<ITEM>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<B> =
            object : ViewHolder<B>(
                layoutId,
                parent,
                bindingVariableId
            ) {
            }


        override fun getItemCount(): Int = list.size


        override fun onBindViewHolder(holder: ViewHolder<B>, position: Int) =
            holder.onBind(list[position])

        fun replaceAll(items : List<ITEM>) {

            list = items
            notifyDataSetChanged()
        }

    }

    abstract class ViewHolder<B : ViewDataBinding>(
        private val layoutId: Int,
        private val parent: ViewGroup,
        private val bindingVariableId: Int?
    ) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
    ) {

        val binding = DataBindingUtil.bind<B>(itemView)

        fun onBind(item: Any?) {
            bindingVariableId?.let {
                binding?.setVariable(it, item)
            }
        }
    }
}