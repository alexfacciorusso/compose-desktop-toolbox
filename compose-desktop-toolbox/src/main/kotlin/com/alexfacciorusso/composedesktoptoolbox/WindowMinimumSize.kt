package com.alexfacciorusso.composedesktoptoolbox

import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowScope
import java.awt.Dimension

@Composable
fun WindowScope.WindowMinimumSize(minimumSize: DpSize) {
    val localDensity = LocalDensity.current

    SideEffect {
        with(localDensity) {
            window.minimumSize =
                Dimension(
                    minimumSize.width.roundToPx(),
                    minimumSize.height.roundToPx()
                )
        }
    }
}

@Composable
fun WindowScope.WindowMinimumSize(minimumWidth: Dp = 0.dp, minimumHeight: Dp = 0.dp) {
    WindowMinimumSize(DpSize(minimumWidth, minimumHeight))
}
