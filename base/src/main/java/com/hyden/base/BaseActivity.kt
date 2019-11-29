package com.hyden.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity<B : ViewDataBinding>(private val layoutId : Int) : AppCompatActivity() {

    lateinit var binding : B
    lateinit var compositeDisposable: CompositeDisposable

    abstract fun initBind()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        compositeDisposable = CompositeDisposable()

        binding = DataBindingUtil.inflate(layoutInflater, layoutId, null, false)
        setContentView(binding.root)
        binding.lifecycleOwner = this

        initBind()

    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}