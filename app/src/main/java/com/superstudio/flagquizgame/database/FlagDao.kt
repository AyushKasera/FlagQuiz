package com.superstudio.flagquizgame.database

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import android.widget.Toast
import com.superstudio.flagquizgame.model.FlagsModel
import kotlin.math.log

class FlagDao {
    fun getRandomTenRecords(helper: DatabaseCopyHelper, context: Context):ArrayList<FlagsModel>{
        val recordList=ArrayList<FlagsModel>()

            val database: SQLiteDatabase = helper.writableDatabase
            val cursor: Cursor = database.rawQuery("SELECT * FROM flags ORDER BY RANDOM() LIMIT 5", null)
            Log.d("ans : cursor ",cursor.count.toString())
            Toast.makeText(context, "cursor "+cursor.count, Toast.LENGTH_SHORT).show()
            val idIndex = cursor.getColumnIndex("flag_id")
            val countryNameIndex = cursor.getColumnIndex("country_name")
            val flagNameIndex = cursor.getColumnIndex("flag_name")
            while (cursor.moveToNext()) {

                val record = FlagsModel(
                    cursor.getInt(idIndex),
                    cursor.getString(countryNameIndex),
                    cursor.getString(flagNameIndex)
                )
                Toast.makeText(context, "record", Toast.LENGTH_SHORT).show()
                recordList.add(record)
            }
            cursor.close()

        return recordList
    }
    fun getRandomThreeRecords(helper: DatabaseCopyHelper, id:Int):ArrayList<FlagsModel>{
        val recordList=ArrayList<FlagsModel>()
        val database:SQLiteDatabase=helper.writableDatabase
        val cursor:Cursor=database.rawQuery("SELECT * FROM flags  WHERE flag_id!=? ORDER BY RANDOM() LIMIT 3",
            arrayOf(id.toString()))
        val idIndex=cursor.getColumnIndex("flag_id")
        val countryNameIndex=cursor.getColumnIndex("country_name")
        val flagNameIndex=cursor.getColumnIndex("flag_name")


        while (cursor.moveToNext())
        {
            val record= FlagsModel(cursor.getInt(idIndex), cursor.getString(countryNameIndex),cursor.getString(flagNameIndex))
            recordList.add(record)
        }
        cursor.close()
        return recordList
    }

}