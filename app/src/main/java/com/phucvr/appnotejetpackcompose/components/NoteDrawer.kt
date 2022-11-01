package com.phucvr.appnotejetpackcompose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.phucvr.appnotejetpackcompose.routing.JetNotesRouter
import com.phucvr.appnotejetpackcompose.routing.Screen
import com.phucvr.appnotejetpackcompose.ui.theme.AppNoteJetpackComposeTheme
import com.phucvr.appnotejetpackcompose.ui.theme.AppNotesThemeSettings

@Composable
private fun AppDrawerHeader() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "AppNotes",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .align(alignment = Alignment.CenterVertically)
                .padding(16.dp)
        )
    }
}

@Preview
@Composable
fun AppDrawerHeaderPreview() {
    AppNoteJetpackComposeTheme() {
        AppDrawerHeader()
    }
}

@Composable
private fun ScreenNavigationButton(
    icon: ImageVector,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val colors = MaterialTheme.colors
    var imageAlpha = 0.6f
    var textColor = colors.onSurface.copy(alpha = 0.6f)
    var backgroundColor = colors.surface

    if (!isSelected) {
        imageAlpha = 1f
        textColor = colors.primary
        backgroundColor = colors.primary.copy(alpha = 0.12f)
    }

    Surface( // 1
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, top = 8.dp),
        color = backgroundColor,
        shape = MaterialTheme.shapes.small
    ) {
        Row( // 2
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable(onClick = onClick)
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            Image(
                imageVector = icon,
                contentDescription = "Screen Navigation Button",
                colorFilter = ColorFilter.tint(textColor),
                alpha = imageAlpha
            )
            Spacer(Modifier.width(16.dp)) // 3
            Text(
                text = label,
                style = MaterialTheme.typography.body2,
                color = textColor,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
fun ScreenNavigationButtonPreview() {
    AppNoteJetpackComposeTheme {
        ScreenNavigationButton(
            icon = Icons.Filled.Home,
            label = "Notes",
            isSelected = true,
            onClick = { }
        )
    }
}

@Composable
private fun LightDarkThemeItem() {
    Row(
        Modifier
            .padding(8.dp)
    ) {
        Text(
            text = "Light/Dark theme",
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f),
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 8.dp)
                .align(alignment = Alignment.CenterVertically)
        )
        Switch(
            checked = AppNotesThemeSettings.isDarkThemeEnabled,
            onCheckedChange = { AppNotesThemeSettings.isDarkThemeEnabled = it },
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp)
                .align(alignment = Alignment.CenterVertically)
        )
    }
}

@Preview
@Composable
fun LightDarkThemeItemPreview() {
    AppNoteJetpackComposeTheme {
        LightDarkThemeItem()
    }
}

@Composable
fun NoteDrawer(
    currentScreen: Screen,
    listScreen: ArrayList<Screen>,
    closeDrawerAction: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        AppDrawerHeader()

        Divider(color = MaterialTheme.colors.onSurface.copy(alpha = .2f))

        LazyColumn {
            items(listScreen) {
                item: Screen ->
                ScreenNavigationButton(
                    icon = item.icon,
                    label = item.label,
                    isSelected = currentScreen::class.java == item::class.java,
                    onClick = {
                        JetNotesRouter.navigateTo(currentScreen)
                        closeDrawerAction()
                    }
                )
            }
        }

        Spacer(modifier = Modifier.size(10.dp))

        Divider(color = MaterialTheme.colors.onSurface.copy(alpha = .2f))

        LightDarkThemeItem()
    }
}

@Preview
@Composable
fun NoteDrawerPreview() {
    val listScreen = ArrayList<Screen>()
    listScreen.add(Screen.Notes(Icons.Filled.Home))
    listScreen.add(Screen.Trash(Icons.Filled.Delete))

    AppNoteJetpackComposeTheme {
        NoteDrawer(Screen.Notes(Icons.Filled.Home), listScreen, {})
    }
}