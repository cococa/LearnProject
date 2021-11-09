package com.cocoa.testjetpack.storage.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(vararg user: User)

    @Query("SELECT * FROM user")
    fun getAllUser(): Flow<List<User>>

}