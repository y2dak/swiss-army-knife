package com.jayd.swissarmyknife.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "notes")
class Note(@PrimaryKey var id: String, @ColumnInfo
                    var note: String)