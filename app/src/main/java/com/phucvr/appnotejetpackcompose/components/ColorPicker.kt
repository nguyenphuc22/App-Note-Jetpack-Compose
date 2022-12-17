package com.phucvr.appnotejetpackcompose.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phucvr.appnotejetpackcompose.model.ColorModel
import com.phucvr.appnotejetpackcompose.util.hexToColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ColorPicker(
    colors: List<ColorModel>,
    onColorSelect: (ColorModel) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Color Picker",
            modifier = Modifier.padding(10.dp),
            style = MaterialTheme.typography.h6)

        LazyVerticalGrid(cells = GridCells.Fixed(3), modifier = Modifier.fillMaxWidth() ) {
            items(colors.size) { itemIndex ->
                val color = colors[itemIndex]
                ColorItem(color = color, onColorSelect = onColorSelect)
            }
        }

    }
}

@Preview
@Composable
fun ColorPickerPreview() {
    ColorPicker(colors = listOf(
        ColorModel.DEFAULT,
        ColorModel.DEFAULT,
        ColorModel.DEFAULT,
        ColorModel.DEFAULT,
        ColorModel.DEFAULT,
        ColorModel.DEFAULT), onColorSelect = {})
}


@Composable
fun ColorItem(
    color: ColorModel,
    onColorSelect: (ColorModel) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .clickable(
            onClick = {
                onColorSelect(color)
            }
        ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NoteColor(color = Color.hexToColor(color.hex), size = 80.dp, border = 2.dp)

        Text(text = color.name, style = MaterialTheme.typography.h5)
    }
}

@Preview
@Composable
fun ColorItemPreview() {
    ColorItem(color = ColorModel.DEFAULT, onColorSelect = {})
}

