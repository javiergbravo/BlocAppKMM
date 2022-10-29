package com.jgbravo.blocappkmm.android.navigation

object Router {

    object NoteList {
        const val SCREEN = "NoteListScreen"
    }

    object NoteDetails {
        const val SCREEN = "NoteDetailsScreen"

        object Args {
            const val NOTE_ID = "noteId"
            const val DEFAULT_NOTE_ID = "-1L"
        }
    }
}