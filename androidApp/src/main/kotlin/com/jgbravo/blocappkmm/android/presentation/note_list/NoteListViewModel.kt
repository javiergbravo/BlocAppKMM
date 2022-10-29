package com.jgbravo.blocappkmm.android.presentation.note_list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jgbravo.blocappkmm.domain.note.Note
import com.jgbravo.blocappkmm.domain.note.NoteDataSource
import com.jgbravo.blocappkmm.domain.note.SearchNotes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteListViewModel @Inject constructor(
    private val noteDataSource: NoteDataSource,
    private val savedStateHandle: SavedStateHandle,
    private val searchNotes: SearchNotes
) : ViewModel() {

    companion object {
        private const val KEY_SH_NOTES = "notes"
        private const val KEY_SH_SEARCH_TEXT = "searchText"
        private const val KEY_SH_IS_SEARCH_ACTIVE = "isSearchActive"
    }

    private val notes = savedStateHandle.getStateFlow(KEY_SH_NOTES, emptyList<Note>())
    private val searchText = savedStateHandle.getStateFlow(KEY_SH_SEARCH_TEXT, "")
    private val isSearchActive = savedStateHandle.getStateFlow(KEY_SH_IS_SEARCH_ACTIVE, false)

    val state = combine(notes, searchText, isSearchActive) { notes, searchText, isSearchActive ->
        NoteListState(
            notes = searchNotes(notes, searchText),
            searchText = searchText,
            isSearchActive = isSearchActive
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), NoteListState())

    /*init {
        viewModelScope.launch {
            (1..10).forEach {
                noteDataSource.insertNote(
                    Note(
                        id = null,
                        title = "Note $it",
                        content = "Content $it",
                        colorHex = Note.generateRandomColor(),
                        created = DateTimeUtil.now()
                    )
                )
            }
        }
    }*/

    fun loadNotes() {
        viewModelScope.launch {
            savedStateHandle[KEY_SH_NOTES] = noteDataSource.getAllNotes()
        }
    }

    fun onSearchTextChange(text: String) {
        savedStateHandle[KEY_SH_SEARCH_TEXT] = text
    }

    fun onToggleSearch() {
        savedStateHandle[KEY_SH_IS_SEARCH_ACTIVE] = !isSearchActive.value
        if (!isSearchActive.value) {
            savedStateHandle[KEY_SH_SEARCH_TEXT] = ""
        }
    }

    fun deleteNoteById(id: Long) {
        viewModelScope.launch {
            noteDataSource.deleteNoteById(id)
            loadNotes()
        }
    }
}