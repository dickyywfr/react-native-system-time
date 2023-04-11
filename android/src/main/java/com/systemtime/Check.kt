package com.systemtime

import android.content.Context
import android.os.Build
import android.provider.Settings
import com.facebook.react.bridge.Callback
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

class Check(private val context: ReactApplicationContext) : ReactContextBaseJavaModule(context) {

    override fun getName(): String {
        return "Check"
    }

    @ReactMethod
    fun checkTime(errorCallback: Callback, successCallback: Callback) {
        try {
            val settingCode = if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.JELLY_BEAN) {
                Settings.System.getInt(context.contentResolver, Settings.System.AUTO_TIME, 0)
            } else {
                Settings.Global.getInt(context.contentResolver, Settings.Global.AUTO_TIME, 0)
            }
            successCallback.invoke(settingCode == 1)
        } catch (e: Exception) {
            errorCallback.invoke(e.message)
        }
    }

    @ReactMethod
    fun checkZone(errorCallback: Callback, successCallback: Callback) {
        try {
            val settingCode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                Settings.Global.getInt(context.contentResolver, Settings.Global.AUTO_TIME_ZONE, 0)
            } else {
                Settings.System.getInt(context.contentResolver, Settings.System.AUTO_TIME_ZONE, 0)
            }
            successCallback.invoke(settingCode == 1)
        } catch (e: Exception) {
            errorCallback.invoke(e.message)
        }
    }
}
