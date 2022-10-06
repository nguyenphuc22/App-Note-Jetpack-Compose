package com.phucvr.appnotejetpackcompose.model

import com.phucvr.appnotejetpackcompose.data.database.model.ColorDbModel

data class ColorModel(
    val id: Long,
    val name: String,
    val hex: String
) {

    companion object {
        val DEFAULT = with(ColorDbModel.DEFAULT_COLOR) { ColorModel(id, name, hex) }
    }
}