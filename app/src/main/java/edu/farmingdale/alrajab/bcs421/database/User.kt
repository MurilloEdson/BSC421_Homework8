package edu.farmingdale.alrajab.bcs421.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(

    @PrimaryKey (autoGenerate = true) val uid: Int?,
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?


){
@Ignore
        constructor(firstName: String?, lastName: String?) : this(null, firstName, lastName)
    }
