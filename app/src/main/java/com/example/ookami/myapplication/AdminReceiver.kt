package com.example.ookami.myapplication

import android.app.admin.DeviceAdminReceiver
import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent

class AdminReceiver : DeviceAdminReceiver() {
    override fun onEnabled(context: Context, intent: Intent?) {
        super.onEnabled(context, intent)
        val manager = context.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
        val component = ComponentName(context.applicationContext, AdminReceiver::class.java)
        manager.setLockTaskPackages(component, arrayOf(context.packageName))
    }
}
