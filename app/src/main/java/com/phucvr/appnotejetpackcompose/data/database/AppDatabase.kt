package com.phucvr.appnotejetpackcompose.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.phucvr.appnotejetpackcompose.data.database.dao.ColorDao
import com.phucvr.appnotejetpackcompose.data.database.dao.NoteDao
import com.phucvr.appnotejetpackcompose.data.database.model.ColorDbModel
import com.phucvr.appnotejetpackcompose.data.database.model.NoteDbModel

@Database(entities = [NoteDbModel::class, ColorDbModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "note-maker-database"
    }

    abstract fun noteDao(): NoteDao

    abstract fun colorDao(): ColorDao
}
