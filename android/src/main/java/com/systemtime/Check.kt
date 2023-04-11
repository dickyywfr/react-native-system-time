package com.systemtime

import android.content.Context
import android.os.Build
import android.provider.Settings
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactMethod

class Check(private val context: ReactApplicationContext) {
    @ReactMethod
    fun checkTime(promise: Promise) {
        try {
            val settingCode = if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.JELLY_BEAN) {
                Settings.System.getInt(context.contentResolver, Settings.System.AUTO_TIME, 0)
            } else {
                Settings.Global.getInt(context.contentResolver, Settings.Global.AUTO_TIME, 0)
            }
            promise.resolve(settingCode == 1)
        } catch (e: Exception) {
            promise.reject(e)
        }
    }

    @ReactMethod
    fun checkZone(promise: Promise) {
        try {
            val settingCode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                Settings.Global.getInt(context.contentResolver, Settings.Global.AUTO_TIME_ZONE, 0)
            } else {
                Settings.System.getInt(context.contentResolver, Settings.System.AUTO_TIME_ZONE, 0)
            }
            promise.resolve(settingCode == 1)
        } catch (e: Exception) {
            promise.reject(e)
        }
    }
}