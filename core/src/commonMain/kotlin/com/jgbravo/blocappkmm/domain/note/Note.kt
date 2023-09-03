package com.jgbravo.blocappkmm.domain.note

import com.jgbravo.blocappkmm.presentation.Colors
import kotlinx.datetime.LocalDateTime

data class Note(
    val id: String?,
    val title: String,
    val content: String,
    val colorHex: Long,
    val created: LocalDateTime
) {

    companion object {
        private val colors = listOf(Colors.RedOrangeHex, Colors.RedPinkHex, Colors.BabyBlueHex, Colors.LightGreenHex)

        fun generateRandomColor() = colors.random()
    }
}