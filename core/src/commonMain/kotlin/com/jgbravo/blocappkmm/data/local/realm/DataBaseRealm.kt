package com.jgbravo.blocappkmm.data.local.realm

import com.jgbravo.blocappkmm.data.local.models.NoteEntity
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

object DataBaseRealm {

    private val config = RealmConfiguration.create(
        setOf(NoteEntity::class)
    )

    fun openRealm(): Realm = Realm.open(config)
}