package com.hyden.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.hyden.util.LogUtil.LogE
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment<B : ViewDataBinding>(private val layoutId : Int) : Fragment() {

    lateinit var binding : B
    lateinit var compositeDisposable: CompositeDisposable
    abstract fun initBind()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        compositeDisposable = CompositeDisposable()
        LogE("onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        binding = DataBindingUtil.inflate(inflater,layoutId,container,false)
        binding.lifecycleOwner = this

        initBind()
        LogE("onCreateView")
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        LogE("onPause")
    }

    override fun onPause() {
        super.onPause()
        LogE("onPause")
    }

    override fun onStop() {
        super.onStop()
        LogE("onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        LogE("onDestroyView")
        compositeDisposable.clear()
    }

    override fun onDestroy() {
        super.onDestroy()
        LogE("onDestroy")
        compositeDisposable.dispose()
    }

}
