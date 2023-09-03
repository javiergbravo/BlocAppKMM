package com.jgbravo.blocappkmm.data.local.realm

import com.jgbravo.blocappkmm.data.local.NoteDataSource
import com.jgbravo.blocappkmm.data.local.models.NoteEntity
import com.jgbravo.blocappkmm.data.note.toEntity
import com.jgbravo.blocappkmm.data.note.toNote
import com.jgbravo.blocappkmm.domain.note.Note
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import org.mongodb.kbson.ObjectId

class NoteRealmDataSource(
    private val realm: Realm
) : NoteDataSource {

    override suspend fun insertNote(note: Note) {
        realm.writeBlocking {
            copyToRealm(note.toEntity())
        }
    }

    override suspend fun getNoteById(id: String): Note? {
        val objectId = try {
            ObjectId(id)
        } catch (e: Exception) {
            null
        }
        return realm.query<NoteEntity>("_id == $0", objectId).find().firstOrNull()?.toNote()
    }

    override suspend fun getAllNotes(): List<Note> {
        return realm.query<NoteEntity>().find().map { it.toNote() }
    }

    override suspend fun deleteNoteById(id: String) {
        realm.writeBlocking {
            val note = query<NoteEntity>("_id == $0", id).find()
            delete(note)
        }
    }
}