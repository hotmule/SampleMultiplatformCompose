package ru.hotmule.sample_multiplatform_compose

import ru.hotmule.common.App
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import dev.chrisbanes.accompanist.insets.LocalWindowInsets
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            ProvideWindowInsets {

                val insets = LocalWindowInsets.current

                App(
                    (insets.systemBars.top / resources.displayMetrics.density).toInt().dp,
                    (insets.systemBars.bottom / resources.displayMetrics.density).toInt().dp
                )
            }
        }
    }
}