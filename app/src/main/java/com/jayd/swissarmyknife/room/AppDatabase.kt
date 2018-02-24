package com.jayd.swissarmyknife.room

import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Database
import com.jayd.swissarmyknife.models.Note
import com.jayd.swissarmyknife.room.note.NoteDao


@Database(entities = arrayOf(Note::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}