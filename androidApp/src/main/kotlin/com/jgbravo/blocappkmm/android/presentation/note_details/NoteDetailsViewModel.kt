package com.jgbravo.blocappkmm.android.presentation.note_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jgbravo.blocappkmm.domain.note.Note
import com.jgbravo.blocappkmm.domain.note.NoteDataSource
import com.jgbravo.blocappkmm.domain.time.DateTimeUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteDetailsViewModel @Inject constructor(
    private val noteDataSource: NoteDataSource,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    companion object {
        const val KEY_NOTE_ID = "noteId"

        /** State flows **/
        private const val KEY_NOTE_TITLE = "noteTitle"
        private const val KEY_IS_TITLE_FOCUSED = "isNoteTitleTextFocused"
        private const val KEY_NOTE_CONTENT = "noteContent"
        private const val KEY_IS_CONTENT_FOCUSED = "isNoteContentTextFocused"
        private const val KEY_NOTE_COLOR = "noteColor"
    }

    private val noteTitle = savedStateHandle.getStateFlow(KEY_NOTE_TITLE, "")
    private val isNoteTitleTextFocused = savedStateHandle.getStateFlow(KEY_IS_TITLE_FOCUSED, false)
    private val noteContent = savedStateHandle.getStateFlow(KEY_NOTE_CONTENT, "")
    private val isNoteContentTextFocused = savedStateHandle.getStateFlow(KEY_IS_CONTENT_FOCUSED, false)
    private val noteColor = savedStateHandle.getStateFlow(KEY_NOTE_COLOR, Note.generateRandomColor())

    val state = combine(
        noteTitle,
        isNoteTitleTextFocused,
        noteContent,
        isNoteContentTextFocused,
        noteColor
    ) { title, isTitleFocused, content, isContentFocused, noteColor ->
        NoteDetailsState(
            noteTitle = title,
            isNoteTitleHintVisible = title.isEmpty() && !isTitleFocused,
            noteContent = content,
            isNoteContentHintVisible = content.isEmpty() && !isContentFocused,
            noteColor = noteColor
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), NoteDetailsState())

    private val _hasNoteBeenSaved = MutableStateFlow(false)
    val hasNoteBeenSaved = _hasNoteBeenSaved.asStateFlow()

    private var existingNoteId: Long? = null

    init {
        savedStateHandle.get<Long>(KEY_NOTE_ID)?.let { existingNoteId ->
            if (existingNoteId == -1L) {
                return@let
            }
            this.existingNoteId = existingNoteId
            viewModelScope.launch {
                noteDataSource.getNoteById(existingNoteId)?.let { note ->
                    savedStateHandle[KEY_NOTE_TITLE] = note.title
                    savedStateHandle[KEY_NOTE_CONTENT] = note.content
                    savedStateHandle[KEY_NOTE_COLOR] = note.colorHex
                }
            }
        }
    }

    fun onNoteTitleChanged(text: String) {
        savedStateHandle[KEY_NOTE_TITLE] = text
    }

    fun onNoteContentChanged(text: String) {
        savedStateHandle[KEY_NOTE_CONTENT] = text
    }

    fun onNoteTitleFocusChanged(isFocused: Boolean) {
        savedStateHandle[KEY_IS_TITLE_FOCUSED] = isFocused
    }

    fun onNoteContentFocusChanged(isFocused: Boolean) {
        savedStateHandle[KEY_IS_CONTENT_FOCUSED] = isFocused
    }

    fun saveNote() {
        viewModelScope.launch {
            noteDataSource.insertNote(
                Note(
                    id = existingNoteId,
                    title = noteTitle.value,
                    content = noteContent.value,
                    colorHex = noteColor.value,
                    created = DateTimeUtil.now()
                )
            )
            _hasNoteBeenSaved.value = true
        }
    }
}