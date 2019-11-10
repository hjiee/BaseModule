package com.hyden.util


import android.util.Log
import com.hyden.base.BuildConfig

object LogUtil {
    private const val TAG = "LogUtil"
    
    fun logV(msg : String) {
        if(BuildConfig.DEBUG) {
            Log.v(TAG,msg)
        }
    }

    fun logD(msg : String) {
        if(BuildConfig.DEBUG) {
            Log.d(TAG,msg)
        }
    }

    fun logI(msg : String) {
        if(BuildConfig.DEBUG) {
            Log.i(TAG,msg)
        }
    }
    
    fun logW(msg : String) {
        if(BuildConfig.DEBUG) {
            Log.w(TAG,msg)
        }
    }
    
    fun logE(msg : String) {
        if(BuildConfig.DEBUG) {
            Log.e(TAG,msg)
        }
    }
}


