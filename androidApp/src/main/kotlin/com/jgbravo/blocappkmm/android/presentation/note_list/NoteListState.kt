package com.jgbravo.blocappkmm.android.presentation.note_list

import com.jgbravo.blocappkmm.domain.note.Note

data class NoteListState(
    val notes: List<Note> = emptyList(),
    val searchText: String = "",
    val isSearchActive: Boolean = false
)