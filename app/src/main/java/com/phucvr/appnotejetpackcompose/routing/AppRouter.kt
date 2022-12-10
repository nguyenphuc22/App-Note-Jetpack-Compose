package com.phucvr.appnotejetpackcompose.routing

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(open val icon: ImageVector, val label : String) {

    class Notes(override val icon: ImageVector) : Screen(icon,"Notes")

    class SaveNote(override val icon: ImageVector) : Screen(icon,"Save Note")

    class Trash(override val icon: ImageVector) : Screen(icon,"Trash")
}

/**
 * Allows you to change the screen in the [MainActivity]
 *
 * Also keeps track of the current screen.
 */
object JetNotesRouter {
    var currentScreen: Screen by mutableStateOf(Screen.Notes(Icons.Filled.Menu))

    fun navigateTo(destination: Screen) {
        currentScreen = destination
    }
}
