package com.jgbravo.blocappkmm.android.presentation.note_details

import com.jgbravo.blocappkmm.presentation.Colors

data class NoteDetailsState(
    val noteTitle: String = "",
    val isNoteTitleHintVisible: Boolean = false,
    val noteContent: String = "",
    val isNoteContentHintVisible: Boolean = false,
    val noteColor: Long = Colors.White
)