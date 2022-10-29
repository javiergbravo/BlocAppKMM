package com.jgbravo.blocappkmm.android.di

import android.app.Application
import com.jgbravo.blocappkmm.data.local.DatabaseDriverFactory
import com.jgbravo.blocappkmm.data.note.SqlDelightNoteDataSource
import com.jgbravo.blocappkmm.database.NoteDatabase
import com.jgbravo.blocappkmm.domain.note.NoteDataSource
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SingletonModule {

    @Singleton
    @Provides
    fun provideSqlDriver(
        app: Application
    ): SqlDriver = DatabaseDriverFactory(context = app).createDriver()

    @Singleton
    @Provides
    fun provideNoteDatabase(
        driver: SqlDriver
    ): NoteDatabase = NoteDatabase(driver)

    @Singleton
    @Provides
    fun provideNoteDataSource(
        noteDatabase: NoteDatabase
    ): NoteDataSource = SqlDelightNoteDataSource(db = noteDatabase)
}
