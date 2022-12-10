package com.phucvr.appnotejetpackcompose.components

import android.content.res.Resources.Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.phucvr.appnotejetpackcompose.ui.theme.Purple200

@Composable
fun Note() {
    Row(modifier = Modifier.fillMaxWidth()
        .background(Color.White)
        .padding(8.dp)
        .fillMaxWidth()) {
        NoteColor(color = Purple200, size = 50.dp, border = 1.dp, padding = 4.dp)
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "Title",
                maxLines = 1,
                style = MaterialTheme.typography.h6)
            Text(text = "Content",
                maxLines = 2,
                style = MaterialTheme.typography.body1)
        }
        Checkbox(
            checked = false,
            onCheckedChange = { },
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview
@Composable
private fun NotePreview() {
    Note()
}