package ru.nak.ied.qrprog.data.databaseConnection

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.nak.ied.qrprog.data.dao.user.IUserDao
import ru.nak.ied.qrprog.data.entities.User

@Database (entities = [User::class], version = 1)
abstract class MainDb : RoomDatabase() {

    abstract fun getUserDao() : IUserDao

    companion object {
        fun getDb(context: Context) : MainDb{
            return Room.databaseBuilder(
                context.applicationContext,
                MainDb::class.java,
                "techno_point.db"
            ).build()
        }
    }
}