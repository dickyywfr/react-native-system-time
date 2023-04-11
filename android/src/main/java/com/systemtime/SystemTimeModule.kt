package com.systemtime

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.Callback


class SystemTimeModule(private val reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  override fun getName(): String {
    return NAME
  }

  // Example method
  // See https://reactnative.dev/docs/native-modules-android

  
  @ReactMethod
  fun checkTime(errorCallback: Callback, successCallback: Callback) {
      val check = Check(reactContext)
      check.checkTime(errorCallback, successCallback)
  }

  @ReactMethod
  fun checkZone(errorCallback: Callback, successCallback: Callback) {
      val check = Check(reactContext)
      check.checkZone(errorCallback, successCallback)
  }

  companion object {
    const val NAME = "SystemTime"
  }
}
