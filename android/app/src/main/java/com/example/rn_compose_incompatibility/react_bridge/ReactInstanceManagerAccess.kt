package com.example.rn_compose_incompatibility.react_bridge

import android.app.Application
import android.content.Context
import com.facebook.react.ReactInstanceManager
import com.facebook.react.ReactNativeHost
import com.facebook.react.ReactPackage
import com.facebook.react.common.LifecycleState
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ReactInstanceManagerAccess@Inject constructor(
    @ApplicationContext context: Context,
    private val packageList: List<ReactPackage>
):
    ReactNativeHost(context.applicationContext as Application) {


    override fun createReactInstanceManager(): ReactInstanceManager {
        val builder = ReactInstanceManager.builder()
            .setApplication(application)
            .setBundleAssetName("index.android.bundle")
            .setJSMainModulePath("index")
            .setUseDeveloperSupport(useDeveloperSupport)
            .setInitialLifecycleState(LifecycleState.BEFORE_CREATE)

        for (reactPackage in packages) {
            builder.addPackage(reactPackage)
        }

        return builder.build()
    }

    override fun getUseDeveloperSupport(): Boolean {
        return true
    }

    override fun getPackages(): List<ReactPackage> {
        return packageList
    }

}
