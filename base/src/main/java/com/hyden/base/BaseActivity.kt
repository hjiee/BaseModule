package com.hyden.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.hyden.util.LogUtil.LogW
import io.reactivex.disposables.CompositeDisposable
import org.koin.androidx.scope.currentScope

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
        lifeCylceLog("onCreate")
    }
    override fun onStart() {
        super.onStart()
        initBind()
        lifeCylceLog("onStart")
    }
    override fun onResume() {
        super.onResume()
        lifeCylceLog("onResume")
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }

    override fun onRestart() {
        super.onRestart()
        lifeCylceLog("onRestart")
    }





    override fun onPause() {
        super.onPause()
        lifeCylceLog("onPause")
    }

    override fun onStop() {
        super.onStop()
        lifeCylceLog("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        lifeCylceLog("onDestroy")
        compositeDisposable.clear()
    }

    private fun lifeCylceLog(name : String) {
        LogW("Activity : ${binding?.lifecycleOwner} / $name")
    }

}