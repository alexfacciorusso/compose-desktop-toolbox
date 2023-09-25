package com.alexfacciorusso.composedesktoptoolbox

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.window.WindowScope
import java.awt.Dimension

fun Modifier.bindWindowMinimumSize(windowScope: WindowScope) = composed {
    with(windowScope) {
        var updated by remember { mutableIntStateOf(0) }

        DisposableEffect(updated) {
            window.preferredSize = null
            window.minimumSize = window.preferredSize

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