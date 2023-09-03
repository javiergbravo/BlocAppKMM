package com.jgbravo.blocappkmm.data

import com.jgbravo.blocappkmm.domain.note.Note

interface NoteRepository {

    suspend fun insertNote(note: Note)

    suspend fun getNoteById(id: String): Note?

    suspend fun getAllNotes(): List<Note>

    suspend fun deleteNoteById(id: String)
}