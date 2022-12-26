package com.phucvr.appnotejetpackcompose.components

import android.content.res.Resources.Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.phucvr.appnotejetpackcompose.model.NoteModel
import com.phucvr.appnotejetpackcompose.ui.theme.Purple200
import com.phucvr.appnotejetpackcompose.util.hexToColor

@Composable
fun Note(
    note: NoteModel,
    onNoteClick: (NoteModel) -> Unit = {},
    onNoteCheckedChange: (NoteModel) -> Unit = {}
) {
    Row(modifier = Modifier.fillMaxWidth()
        .background(Color.White)
        .padding(8.dp)
        .fillMaxWidth()
        .clickable { onNoteClick(note) }) {
        NoteColor(color = Color.hexToColor(note.color.hex), size = 50.dp, border = 1.dp, padding = 4.dp)
        Column(modifier = Modifier.weight(1f).padding(start = 12.dp )) {
            Text(text = note.title,
                maxLines = 1,
                style = MaterialTheme.typography.h6)
            Text(text = note.content,
                maxLines = 2,
                style = MaterialTheme.typography.body1)
        }
        if (note.isCheckedOff != null) {
            Checkbox(
                checked = note.isCheckedOff,
                onCheckedChange = { isChecked ->
                    val newNote = note.copy(isCheckedOff = isChecked)
                    onNoteCheckedChange(newNote)
                },
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Preview
@Composable
private fun NotePreview() {
    Note(note = NoteModel(1, "Note 1", "Content 1", null))
}