package com.hyden.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.hyden.util.LogUtil.logE

abstract class BaseFragment<B : ViewDataBinding>(private val layoutId : Int) : Fragment() {

    lateinit var binding : B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}