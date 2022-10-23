package com.phucvr.appnotejetpackcompose.data.database.dbmapper

import com.phucvr.appnotejetpackcompose.data.database.model.ColorDbModel
import com.phucvr.appnotejetpackcompose.data.database.model.NoteDbModel
import com.phucvr.appnotejetpackcompose.model.ColorModel
import com.phucvr.appnotejetpackcompose.model.NoteModel

interface DbMapper {

    fun mapNotes(
        noteDbModels: List<NoteDbModel>,
        colorDbModels: Map<Long, ColorDbModel>
    ): List<NoteModel>

    fun mapNote(noteDbModel: NoteDbModel, colorDbModel: ColorDbModel): NoteModel

    fun mapColors(colorDbModels: List<ColorDbModel>): List<ColorModel>

    fun mapColor(colorDbModel: ColorDbModel): ColorModel

    fun mapDbNote(note: NoteModel): NoteDbModel

    fun mapDbColors(colors: List<ColorModel>): List<ColorDbModel>

    fun mapDbColor(color: ColorModel): ColorDbModel

}