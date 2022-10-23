package com.phucvr.appnotejetpackcompose.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ColorDbModel(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "hex") val hex: String,
    @ColumnInfo(name = "name") val name: String
) {

    companion object {

        val DEFAULT_COLORS = listOf(
            ColorDbModel(1, "#FFFFFF", "White"),
            ColorDbModel(2, "#00ACC1", "Cyan"),
            ColorDbModel(3, "#26A69A", "Teal"),
            ColorDbModel(4, "#4CAF50", "Green"),
            ColorDbModel(5, "#8BC34A", "Light Green"),
            ColorDbModel(6, "#CDDC39", "Lime"),
            ColorDbModel(7, "#FFEB3B", "Yellow"),
            ColorDbModel(8, "#FF9800", "Orange"),
            ColorDbModel(9, "#BCAAA4", "Brown"),
            ColorDbModel(10, "#9E9E9E", "Gray"),
            ColorDbModel(11, "#E57373", "Red"),
            ColorDbModel(12, "#F06292", "Pink"),
            ColorDbModel(13, "#CE93D8", "Purple"),
            ColorDbModel(14, "#2196F3", "Blue"),
        )

        val DEFAULT_COLOR = DEFAULT_COLORS[0]
    }
}