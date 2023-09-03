package com.jgbravo.blocappkmm.data.local.models

import io.realm.kotlin.types.RealmInstant
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.Index
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class NoteEntity : RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId.invoke()
    var title: String = ""
    var content: String = ""
    var colorHex: Long = -1L
    var created: Long = 0

    @Index
    var timestamp: RealmInstant = RealmInstant.now()
}