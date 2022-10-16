package com.phucvr.appnotejetpackcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.phucvr.appnotejetpackcompose.ui.theme.AppNoteJetpackComposeTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNoteJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    IconSplash()
                }
            }
        }

        lifecycleScope.launch(Dispatchers.Main) {
            delay(2000)
            val intent = Intent(this@SplashActivity,
                MainActivity::class.java)
            startActivity(intent)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IconSplash() {
    AppNoteJetpackComposeTheme {
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo")
    }
}