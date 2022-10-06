package com.phucvr.appnotejetpackcompose

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.phucvr.appnotejetpackcompose.ui.theme.AppNoteJetpackComposeTheme
import kotlinx.coroutines.*

class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colors.background) {
                IconPlash()

            }
        }

        lifecycleScope.launch {
            delay(2000)
            withContext(Dispatchers.Main) {
                this@SplashActivity.startActivity(
                    Intent(this@SplashActivity.application,MainActivity::class.java))
            }
        }
    }
}

@Composable
@Preview()
fun IconPlash() {
    AppNoteJetpackComposeTheme {
        // A surface container using the 'background' color from the theme
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Image(painter = painterResource(id = R.drawable.logo),
                contentDescription ="Logo Image" )
        }
    }
}