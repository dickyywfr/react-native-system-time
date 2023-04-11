package com.systemtime

import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

class SystemTimeModule(private val reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  override fun getName() = NAME

  @ReactMethod
  fun checkTime(promise: Promise) {
      val check = Check(reactContext)
      check.checkTime(promise)
  }

  @ReactMethod
  fun checkZone(promise: Promise) {
      val check = Check(reactContext)
      check.checkZone(promise)
  }

  companion object {
    const val NAME = "SystemTime"
  }
}