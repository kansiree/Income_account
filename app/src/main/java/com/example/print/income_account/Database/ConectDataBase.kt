package com.example.print.income_account.Database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

/**
 * Created by print on 9/25/2017.
 */
class ConectDataBase(context:Context?):ConstanData {

    val helper:HelperData = HelperData(context)
    public fun addData(ID:Int,date:String,type:String,menu:String,money:Int){
        val sqlLiteOpenHelper: SQLiteDatabase? = helper.writableDatabase
         var values: ContentValues = ContentValues()

        values.put(COLOUMN_ID,ID)
        values.put(COLOUMN_DATE,date)
        values.put(COLOUMN_MENU,menu)
        values.put(COLOUMN_TYPE,type)
        values.put(COLOUMN_MONEY,money)
        sqlLiteOpenHelper!!.insert(Table_Name, null,values)
    }

    public fun readData():Cursor{
        val sqLiteOpenHelper = helper.readableDatabase
        val sql:String = "SELECT * FROM "+Table_Name
        val cursor:Cursor = sqLiteOpenHelper.rawQuery(sql, null)
        return cursor
    }
}