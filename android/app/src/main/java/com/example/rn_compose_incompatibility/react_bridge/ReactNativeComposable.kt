package com.example.rn_compose_incompatibility.react_bridge

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun ReactNativeComposableView(
    component: String,
    modifier: Modifier = Modifier,
) {
    AndroidView(
        modifier = modifier.fillMaxSize(),
        factory = { context ->
            ReactNativeRootViewWrapper(
                context = context,
                component = component,
            )
        }
    )
}
