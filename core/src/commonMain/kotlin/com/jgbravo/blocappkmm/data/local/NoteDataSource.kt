package com.jgbravo.blocappkmm.data.local

import com.jgbravo.blocappkmm.domain.note.Note

interface NoteDataSource {

    suspend fun insertNote(note: Note)

    suspend fun getNoteById(id: String): Note?

    suspend fun getAllNotes(): List<Note>

    suspend fun deleteNoteById(id: String)
}