package com.phucvr.appnotejetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.phucvr.appnotejetpackcompose.components.Note
import com.phucvr.appnotejetpackcompose.components.NoteDrawer
import com.phucvr.appnotejetpackcompose.routing.Screen
import com.phucvr.appnotejetpackcompose.ui.theme.AppNoteJetpackComposeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNoteJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainView()
                }
            }
        }
    }
}

@Composable
fun MainView() {
    val coroutineScope = rememberCoroutineScope()
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val listScreen = ArrayList<Screen>()
    listScreen.add(Screen.Notes(Icons.Filled.Home))
    listScreen.add(Screen.Trash(Icons.Filled.Delete))

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            NoteDrawer(
                currentScreen = Screen.Notes(Icons.Filled.Menu),
                listScreen = listScreen as ArrayList<Screen>
            ) {
                coroutineScope.launch {
                    scaffoldState.drawerState.close()
                }
            }
        },
        content = {
            Note()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppNoteJetpackComposeTheme {
        MainView()
    }
}