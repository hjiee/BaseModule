package com.hyden.base

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    val compositeDisposable = CompositeDisposable()
    val loading = ObservableField<Boolean>()

    init {
        loading.set(false)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
        hideLoading()
    }

    fun showLoading() {
        loading.set(true)
    }

    fun hideLoading() {
        loading.set(false)
    }
}