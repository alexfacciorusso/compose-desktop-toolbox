package com.alexfacciorusso.composedesktoptoolbox

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowScope
import java.awt.Dimension

@ExperimentalComposeDesktopToolboxApi
fun Modifier.bindWindowMinimumSize(windowScope: WindowScope) = composed {
    with(windowScope) {
        val localDensity = LocalDensity.current
        var updated by remember { mutableIntStateOf(0) }

        DisposableEffect(updated, localDensity) {
            window.preferredSize = null
            val calculatedPreferredSize = window.preferredSize

            with(localDensity) {
                window.minimumSize =
                    Dimension(
                        calculatedPreferredSize.width.dp.roundToPx(),
                        calculatedPreferredSize.height.dp.roundToPx()
                    )
            }

            onDispose {
                window.minimumSize = Dimension()
            }
        }

        onSizeChanged {
            if (updated == Int.MAX_VALUE) {
                updated = 0
                return@onSizeChanged
            }

            updated++
        }
    }
}