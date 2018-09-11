# OrientationTest

Minimal project to reproduce orientation bug on Samsung tablet SM-T580. Reported [here](https://developer.samsung.com/forum/board/thread/view.do?messageId=353382).

## Bug description

Tablet ignores locked screen orientation defined in app manifest, if:
- app has permission to start lock task mode and initial activity launches with `android:lockTaskMode="if_whitelisted"`
- app starts on device boot
- app has locked screen orientation defined in manifest
- you don't unlock the device until the app has been launched

If you unlock the device before the app has been launched (so that you see the launcher window), then locked orientation is respected. Otherwise you can turn the tablet and see that orientation setting is ignored.

## Steps to reproduce
- install and run application
- run `adb shell dpm set-device-owner com.example.ookami.myapplication/.AdminReceiver` – the app will be set as device owner. This is needed in order to grant lock task permission to the application.
- reboot the tablet. Don't unlock it, let the application start automatically
- turn the tablet to see that locked screen orientation is ignored.
- in order to unset app as device owner, run `adb shell dpm remove-active-admin com.example.ookami.myapplication/.AdminReceiver`
