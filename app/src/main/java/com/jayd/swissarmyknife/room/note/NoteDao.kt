package com.jayd.swissarmyknife.room.note

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.jayd.swissarmyknife.models.Note

@Dao
interface NoteDao {
    @get:Query("SELECT * FROM notes")
    val all: List<Note>

    @Insert
    fun insert(note: Note)

    @Delete
    fun delete(note: Note)
}