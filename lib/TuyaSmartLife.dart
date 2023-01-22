import 'package:flutter/services.dart';

class TuyaSmartLife {
  static const MethodChannel _channel =
      MethodChannel('tuya_smart_life');

  static Future<String> initialize({required String appKey,required String appSecret}) async {
    final String result = await _channel.invokeMethod('initialize', {
      'appKey': appKey,
      'appSecret': appSecret,
    });
    return result;
  }
}
