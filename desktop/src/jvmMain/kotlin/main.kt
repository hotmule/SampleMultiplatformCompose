import ru.hotmule.common.ui.RootScreen
import androidx.compose.desktop.Window
import com.arkivanov.decompose.extensions.compose.jetbrains.rememberRootComponent
import ru.hotmule.common.main.Root

fun main() = Window {
    RootScreen(rememberRootComponent(factory = ::Root))
}