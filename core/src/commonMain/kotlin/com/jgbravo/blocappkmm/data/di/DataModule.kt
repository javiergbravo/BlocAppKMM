package com.jgbravo.blocappkmm.data.di

import com.jgbravo.blocappkmm.data.NoteRepository
import com.jgbravo.blocappkmm.data.NoteRepositoryImpl
import com.jgbravo.blocappkmm.data.local.NoteDataSource
import com.jgbravo.blocappkmm.data.local.realm.DataBaseRealm
import com.jgbravo.blocappkmm.data.local.realm.NoteRealmDataSource
import io.realm.kotlin.Realm
import org.koin.dsl.module

val dataModule = module {
    single<Realm> { DataBaseRealm.openRealm() }
    single<NoteDataSource> { NoteRealmDataSource(realm = get()) }
    single<NoteRepository> { NoteRepositoryImpl(noteDataSource = get()) }
}