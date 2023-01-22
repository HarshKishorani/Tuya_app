package com.example.tuya_app

import androidx.annotation.NonNull
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity() {
  private val CHANNEL = "tuya_smart_life"

  override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
    super.configureFlutterEngine(flutterEngine)
    MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler {
      call, result ->
      if(call.method == "initialize"){
        val appKey = call.argument<String>("appKey")
        val appSecret = call.argument<String>("appSecret")
        TuyaHomeSdk.init(this, appKey,appSecret)
        result.success("Success")
      }
      else{
        result.notImplemented()
      }
    }
  }
}