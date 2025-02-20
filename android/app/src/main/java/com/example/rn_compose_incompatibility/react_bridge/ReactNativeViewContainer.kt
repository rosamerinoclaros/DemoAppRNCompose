package com.example.rn_compose_incompatibility.react_bridge

import android.app.Activity
import android.content.Context
import com.facebook.react.ReactRootView

class ReactNativeViewContainer(
    private var activityContext: Context,
    private var reactInstanceManagerAccess: ReactInstanceManagerAccess
) {

    private var reactNativeView: ReactRootView = createRootView()

    private var started = false

    init {
        if (activityContext !is Activity) {
            throw IllegalArgumentException(
                ReactNativeViewContainer::class.java.simpleName +
                    " must be used only in activity context!",
            )
        }
    }

    fun startReactNativeComponent(component: String): ReactRootView {
        if (!started) {
            started = true
            reactNativeView.startReactApplication(
                reactInstanceManagerAccess.reactInstanceManager,
                component,
                null,
            )
        }
        return reactNativeView
    }

    private fun createRootView(): ReactRootView = ReactRootView(activityContext)
}
