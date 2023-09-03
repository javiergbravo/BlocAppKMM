package com.jgbravo.blocappkmm.data.note

import com.jgbravo.blocappkmm.data.local.models.NoteEntity
import com.jgbravo.blocappkmm.domain.note.Note
import com.jgbravo.blocappkmm.domain.time.DateTimeUtil
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun NoteEntity.toNote(): Note {
    return Note(
        id = _id.toHexString(),
        title = title,
        content = content,
        colorHex = colorHex,
        created = Instant.fromEpochMilliseconds(created).toLocalDateTime(TimeZone.currentSystemDefault()),
    )
}

fun Note.toEntity(): NoteEntity {
    return NoteEntity().apply {
        title = this@toEntity.title
        content = this@toEntity.content
        colorHex = this@toEntity.colorHex
        created = DateTimeUtil.toEpochMillis(this@toEntity.created)
    }
}