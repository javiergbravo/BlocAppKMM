package com.jgbravo.blocappkmm.di

import com.jgbravo.blocappkmm.data.local.DatabaseDriverFactory
import com.jgbravo.blocappkmm.data.note.SqlDelightNoteDataSource
import com.jgbravo.blocappkmm.database.NoteDatabase
import com.jgbravo.blocappkmm.domain.note.NoteDataSource

class DatabaseModule {

    private val factory by lazy { DatabaseDriverFactory() }
    val noteDataSource: NoteDataSource by lazy {
        SqlDelightNoteDataSource(NoteDatabase(factory.createDriver()))
    }
}