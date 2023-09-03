package com.jgbravo.blocappkmm.android.di

import com.jgbravo.blocappkmm.android.presentation.di.presentationModule
import com.jgbravo.blocappkmm.di.coreModule

val androidModule = coreModule.plus(presentationModule)