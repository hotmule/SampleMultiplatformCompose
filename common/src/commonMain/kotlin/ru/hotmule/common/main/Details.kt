package ru.hotmule.common.main

import com.arkivanov.decompose.ComponentContext

class Details(
    componentContext: ComponentContext,
    val text: String,
    private val onFinished: () -> Unit
) : ComponentContext by componentContext {

    fun onBackClicked() {
        onFinished()
    }
}