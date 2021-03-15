package ru.hotmule.sample_multiplatform_compose

import ru.hotmule.common.ui.RootScreen
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.arkivanov.decompose.extensions.compose.jetbrains.rememberRootComponent
import dev.chrisbanes.accompanist.insets.LocalWindowInsets
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets
import ru.hotmule.common.main.Root

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            ProvideWindowInsets {

                val systemBarInsets = LocalWindowInsets.current.systemBars
                val density = resources.displayMetrics.density

                //val statusBarHeight = (systemBarInsets.top / density).toInt().dp
                //val navBarHeight = (systemBarInsets.bottom / density).toInt().dp

                RootScreen(
                    rememberRootComponent { componentContext ->
                        Root(
                            componentContext,
                            statusBarHeight = 24.dp,
                            navBarHeight = 16.dp
                        )
                    },
                )
            }
        }
    }
}