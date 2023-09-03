package com.jgbravo.blocappkmm.android.presentation.di

import com.jgbravo.blocappkmm.android.presentation.note_details.NoteDetailsViewModel
import com.jgbravo.blocappkmm.android.presentation.note_list.NoteListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        NoteListViewModel(
            noteRepository = get(),
            savedStateHandle = get(),
            searchNotes = get()
        )
    }
    viewModel {
        NoteDetailsViewModel(
            noteRepository = get(),
            savedStateHandle = get()
        )
    }
}