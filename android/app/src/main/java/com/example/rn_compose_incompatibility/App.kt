package com.example.rn_compose_incompatibility

import android.app.Application
import com.facebook.react.PackageList
import com.facebook.react.ReactApplication
import com.facebook.react.ReactNativeHost
import com.facebook.react.ReactPackage
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application(), ReactApplication {

        override val reactNativeHost: ReactNativeHost = object : ReactNativeHost(this) {
            override fun getUseDeveloperSupport(): Boolean {
                return BuildConfig.DEBUG
            }
            override fun getPackages(): List<ReactPackage> {
                return PackageList(this).packages
            }

            override fun getJSMainModuleName(): String {
                return "index"
            }
        }
}