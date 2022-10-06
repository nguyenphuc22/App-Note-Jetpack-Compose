package com.phucvr.appnotejetpackcompose.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteDbModel(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "can_be_checked_off") val canBeCheckedOff: Boolean,
    @ColumnInfo(name = "is_checked_off") val isCheckedOff: Boolean,
    @ColumnInfo(name = "color_id") val colorId: Long,
    @ColumnInfo(name = "in_trash") val isInTrash: Boolean
) {

    companion object {

        val DEFAULT_NOTES = listOf(
            NoteDbModel(1, "Task A", "Do something", false, false, 1, false),
            NoteDbModel(2, "Task B", "Do something", false, false, 2, false),
            NoteDbModel(3, "Task C", "Do something", false, false, 3, false),
            NoteDbModel(4, "Task D", "Do something", false, false, 4, false),
            NoteDbModel(5, "Task E", "Do something", true, false, 5, false),
            NoteDbModel(6, "Task F", "Do something", false, false, 6, false),
            NoteDbModel(7, "Task G", "Do something", true, false, 7, false),
            NoteDbModel(8, "Task H", "Do something", false, false, 8, false),
            NoteDbModel(9, "Task Q", "Do something", false, false, 9, false),
            NoteDbModel(10, "Task W", "Do something", false, false, 10, false),
            NoteDbModel(11, "Task E", "Do something", true, false, 11, false),
            NoteDbModel(12, "Task T", "Do something", true, false, 12, false)
        )
    }
}