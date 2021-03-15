package ru.hotmule.common.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.arkivanov.decompose.ComponentContext
import kotlin.collections.List
import com.arkivanov.decompose.statekeeper.Parcelable
import com.arkivanov.decompose.statekeeper.Parcelize
import com.arkivanov.decompose.statekeeper.consume

class List(
    private val componentContext: ComponentContext,
    private val onItemSelected: (String) -> Unit
) : ComponentContext by componentContext {

    private val _model = mutableStateOf(stateKeeper.consume("state") ?: Model())
    val model: State<Model> = _model

    init {
        stateKeeper.register("state") { _model.value }
    }

    fun onItemClicked(item: String) {
        onItemSelected(item)
    }

    fun onTextChanged(text: String) {
        changeState { copy(text = text) }
    }

    fun onAddClicked() {
        changeState { copy(items = items + text, text = "") }
    }

    private inline fun changeState(reducer: Model.() -> Model): Model {
        val newModel = model.value.reducer()
        _model.value = newModel
        return newModel
    }

    @Parcelize
    data class Model(
        val items: List<String> = emptyList(),
        val text: String = ""
    ) : Parcelable
}