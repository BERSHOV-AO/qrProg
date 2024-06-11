package ru.nak.ied.qrprog.data.dao.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.nak.ied.qrprog.data.entities.User
import kotlinx.coroutines.flow.Flow

@Dao
interface IUserDao {

    @Insert
    fun insertItem(user: User)

    @Query("SELECT * FROM users")
    fun getAllUsers(): Flow<List<User>>
}