package com.jgbravo.blocappkmm.di

import com.jgbravo.blocappkmm.data.NoteRepository
import com.jgbravo.blocappkmm.data.NoteRepositoryImpl
import com.jgbravo.blocappkmm.data.local.NoteDataSource
import com.jgbravo.blocappkmm.data.local.realm.DataBaseRealm
import com.jgbravo.blocappkmm.data.local.realm.NoteRealmDataSource

object DatabaseModule {

    private val noteDataSource: NoteDataSource by lazy {
        NoteRealmDataSource(DataBaseRealm.openRealm())
    }

    val noteRepository: NoteRepository by lazy {
        NoteRepositoryImpl(noteDataSource)
    }
}