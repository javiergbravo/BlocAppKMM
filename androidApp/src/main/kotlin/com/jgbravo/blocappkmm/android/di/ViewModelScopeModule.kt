package com.jgbravo.blocappkmm.android.di

import com.jgbravo.blocappkmm.domain.note.SearchNotes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelScopeModule {

    @Provides
    fun provideSearchNotes() = SearchNotes()
}