import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.alexfacciorusso.composedesktoptoolbox.ExperimentalComposeDesktopToolboxApi
import com.alexfacciorusso.composedesktoptoolbox.bindWindowMinimumSize

@Composable
fun Content(modifier: Modifier) {
    var isLastShown by remember { mutableStateOf(true) }
    Column(modifier.wrapContentWidth()) {
        Row {
            Box(Modifier.size(100.dp).background(Color.Red))
            Box(Modifier.size(200.dp).background(Color.Yellow))
            Box(Modifier.size(120.dp).background(Color.Cyan))
            if (isLastShown) {
                Box(Modifier.size(300.dp).background(Color.Green))
            }
        }
        Button(onClick = {
            isLastShown = !isLastShown
        }) {
            val label = if (isLastShown) "Hide" else "Show"
            Text("$label last container")
        }
    }
}

@Composable
@Preview
fun App(modifier: Modifier = Modifier) {
    MaterialTheme {
        Content(modifier)
    }
}

@OptIn(ExperimentalComposeDesktopToolboxApi::class)
fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App(modifier = Modifier.bindWindowMinimumSize(this))
    }
}
