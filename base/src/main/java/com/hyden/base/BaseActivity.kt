package com.hyden.base

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.hyden.ext.showSimpleDialog
import com.hyden.ext.moveToActivity
import com.hyden.util.ConstValueUtil.Companion.DEF_REQUEST_PERMISSION_CODE
import com.hyden.util.LogUtil.LogW
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
        lifeCylceLog("onCreate")
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode) {
            DEF_REQUEST_PERMISSION_CODE -> {
                showSimpleDialog("권한이 필요합니다. 권한설정 화면으로 이동하시겠습니까?") {
                    Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                        data = Uri.fromParts("package",packageName,null)
                        moveToActivity(this)
                    }
                }
            }
        }
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
//        LogW("Activity : ${binding?.lifecycleOwner} / $name")
    }

}