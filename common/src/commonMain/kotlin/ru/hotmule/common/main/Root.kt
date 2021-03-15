package ru.hotmule.common.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.*
import com.arkivanov.decompose.statekeeper.Parcelable
import com.arkivanov.decompose.statekeeper.Parcelize
import com.arkivanov.decompose.value.Value
import ru.hotmule.common.ui.DetailsScreen
import ru.hotmule.common.ui.ListScreen

typealias Content = @Composable () -> Unit

fun <T : Any> T.asContent(content: @Composable (T) -> Unit): Content = { content(this) }

class Root(
    componentContext: ComponentContext,
    private val statusBarHeight: Dp = 0.dp,
    private val navBarHeight: Dp = 0.dp
) : ComponentContext by componentContext {

    private val router = router<Config, Content>(
        initialConfiguration = Config.List,
        handleBackButton = true,
        componentFactory = ::createChild
    )

    val routerState: Value<RouterState<*, Content>> = router.state

    private fun createChild(config: Config, componentContext: ComponentContext): Content =
        when (config) {
            is Config.List -> createList(componentContext)
                .asContent { ListScreen(it, statusBarHeight, navBarHeight) }
            is Config.Details -> createDetails(componentContext, config)
                .asContent { DetailsScreen(it, statusBarHeight) }
        }

    private fun createList(componentContext: ComponentContext): List =
        List(componentContext) { router.push(Config.Details(text = it)) }

    private fun createDetails(componentContext: ComponentContext, config: Config.Details): Details =
        Details(componentContext, config.text, router::pop)

    private sealed class Config : Parcelable {
        @Parcelize object List : Config()
        @Parcelize data class Details(val text: String) : Config()
    }
}