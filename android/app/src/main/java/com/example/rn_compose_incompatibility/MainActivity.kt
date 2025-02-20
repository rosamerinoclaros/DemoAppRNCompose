package com.example.rn_compose_incompatibility

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.unit.dp
import com.example.rn_compose_incompatibility.react_bridge.ReactInstanceManagerAccess
import com.example.rn_compose_incompatibility.react_bridge.ReactNativeComposableView
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint.load
import com.facebook.react.soloader.OpenSourceMergedSoMapping
import com.facebook.soloader.SoLoader
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var reactInstanceManagerAccess: ReactInstanceManagerAccess

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SoLoader.init(this, OpenSourceMergedSoMapping)
        if (BuildConfig.IS_NEW_ARCHITECTURE_ENABLED) {
            load()
        }

        setContent {

            BoxWithConstraints(
                Modifier
                    .fillMaxSize()
                    .statusBarsPadding(),
            ) {
                val scaffoldState = rememberBottomSheetScaffoldState(
                    bottomSheetState = rememberStandardBottomSheetState(
                        initialValue = SheetValue.PartiallyExpanded
                    )
                )

                val nestedScrollConnection = rememberNestedScrollInteropConnection()

                val halfExpandedHeight = remember { (maxHeight * 0.5f) + 20.dp }

                BottomSheetScaffold(
                    scaffoldState = scaffoldState,
                    sheetContent = {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(32.dp)
                                .background(Color.Red)
                                .nestedScroll(nestedScrollConnection)
                        ) {
                            // Uncomment to make the react native view scrollable with one finger
                            // but ignoring the sticky header inside the react native view
                            /* val lazyListState = rememberLazyListState(initialFirstVisibleItemIndex = 0)
                                     LazyColumn(
                                        verticalArrangement = Arrangement.Top,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        userScrollEnabled = true,
                                        state = lazyListState,
                                        modifier = Modifier.fillMaxWidth(),
                                   ) {
                                       item {
                             */
                            ReactNativeComposableView("RnComposeIncompatibility")
                            //  }}
                        }
                    },
                    sheetDragHandle = null,
                    sheetPeekHeight = halfExpandedHeight,
                    sheetShape = RoundedCornerShape(0.dp),
                ) { }
            }
        }
    }
}