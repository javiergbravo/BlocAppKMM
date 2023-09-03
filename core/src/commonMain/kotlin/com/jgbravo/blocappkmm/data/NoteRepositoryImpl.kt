package com.jgbravo.blocappkmm.data

import com.jgbravo.blocappkmm.data.local.NoteDataSource
import com.jgbravo.blocappkmm.domain.note.Note

class NoteRepositoryImpl(
    private val noteDataSource: NoteDataSource
) : NoteRepository {

    override suspend fun insertNote(note: Note) = noteDataSource.insertNote(note = note)

    override suspend fun getNoteById(id: String): Note? = noteDataSource.getNoteById(id = id)

    override suspend fun getAllNotes(): List<Note> = noteDataSource.getAllNotes()

    override suspend fun deleteNoteById(id: String) = noteDataSource.deleteNoteById(id = id)
}