package com.jgbravo.blocappkmm.di

import com.jgbravo.blocappkmm.data.di.dataModule
import com.jgbravo.blocappkmm.domain.di.domainModule

val coreModule = listOf(
    dataModule,
    domainModule
)