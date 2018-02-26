package com.jayd.swissarmyknife.room.note

import com.jayd.swissarmyknife.models.Note
import com.jayd.swissarmyknife.room.AppDatabase

class NoteDBHelper(appDatabase: AppDatabase) {
    private val noteDao = appDatabase.noteDao()

    fun insert(note: Note) {
        noteDao.insert(note)
    }

}