package com.cocoa.testjetpack.storage.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(User::class), version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao


    companion object {

        private lateinit var db: AppDatabase


        fun getInstance(context: Context): AppDatabase {
            db = Room.databaseBuilder(context, AppDatabase::class.java, "db-user").build()
            return db;
        }


    }

}