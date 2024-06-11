package ru.nak.ied.qrprog.data.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "surname")
    var surname: String,
    @ColumnInfo(name = "userNumber")
    var userNumber: String,
    @ColumnInfo(name = "userPassword")
    var userPassword: String
)

