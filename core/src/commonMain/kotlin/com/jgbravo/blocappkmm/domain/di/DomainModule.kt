package com.jgbravo.blocappkmm.domain.di

import com.jgbravo.blocappkmm.domain.note.SearchNotes
import org.koin.dsl.module

val domainModule = module {
    factory { SearchNotes() }
}