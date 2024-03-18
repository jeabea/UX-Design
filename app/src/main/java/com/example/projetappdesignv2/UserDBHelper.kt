package com.example.projetappdesignv2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UserDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "UserDatabase.db"

        private const val SQL_CREATE_ENTRIES =
            "CREATE TABLE ${UserContract.UserEntry.TABLE_NAME} (" +
                    "${UserContract.UserEntry.COLUMN_NAME_USERNAME} TEXT PRIMARY KEY," +
                    "${UserContract.UserEntry.COLUMN_NAME_EMAIL} TEXT," +
                    "${UserContract.UserEntry.COLUMN_NAME_PASSWORD} TEXT)"

        private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${UserContract.UserEntry.TABLE_NAME}"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    fun addUser(username: String, email: String, password: String) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(UserContract.UserEntry.COLUMN_NAME_USERNAME, username)
            put(UserContract.UserEntry.COLUMN_NAME_EMAIL, email)
            put(UserContract.UserEntry.COLUMN_NAME_PASSWORD, password)
        }
        val newRowId = db?.insert(UserContract.UserEntry.TABLE_NAME, null, values)
    }

    fun userExists(username: String, password: String): Boolean {
        val db = readableDatabase
        val projection = arrayOf(UserContract.UserEntry.COLUMN_NAME_USERNAME)
        val selection = "${UserContract.UserEntry.COLUMN_NAME_USERNAME} = ? AND ${UserContract.UserEntry.COLUMN_NAME_PASSWORD} = ?"
        val selectionArgs = arrayOf(username, password)
        val cursor = db.query(
            UserContract.UserEntry.TABLE_NAME,
            projection,
            selection,
            selectionArgs,
            null,
            null,
            null
        )
        val userExists = cursor.count > 0
        cursor.close()
        return userExists
    }




}

object UserContract {
    object UserEntry {
        const val TABLE_NAME = "users"
        const val COLUMN_NAME_USERNAME = "username"
        const val COLUMN_NAME_EMAIL = "email"
        const val COLUMN_NAME_PASSWORD = "password"
    }
}
