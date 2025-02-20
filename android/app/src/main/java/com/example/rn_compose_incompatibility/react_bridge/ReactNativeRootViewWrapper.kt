package com.example.rn_compose_incompatibility.react_bridge

import android.annotation.SuppressLint
import android.content.Context
import android.widget.FrameLayout
import com.facebook.react.ReactRootView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@SuppressLint("ViewConstructor")
@AndroidEntryPoint
class ReactNativeRootViewWrapper(
    context: Context,
    component: String,
) : FrameLayout(context) {

    @Inject
    lateinit var reactInstanceManagerAccess: ReactInstanceManagerAccess
    private var reactContainer = ReactNativeViewContainer(context, reactInstanceManagerAccess)
    private var rootView: ReactRootView = reactContainer.startReactNativeComponent(component)

    init {
        rootView.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        rootView.isNestedScrollingEnabled = true

        addView(rootView)
    }
}
