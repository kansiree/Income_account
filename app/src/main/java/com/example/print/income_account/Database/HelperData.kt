package com.example.print.income_account.Database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
/**
 * Created by print on 9/25/2017.
 */
private val Database_Name:String = "income_base.db"

class HelperData(context: Context?) : SQLiteOpenHelper(context, Database_Name, null, 1),ConstanData{

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        p0!!.execSQL("CREATE TABLE "+Table_Name+" ("+
                COLOUMN_ID+" INTEGER PRIMARY KEY, "+
                COLOUMN_DATE+" TEXT NOT NULL,"+
                COLOUMN_TYPE+" TEXT NOT NULL,"+
                COLOUMN_MENU+" TEXT NOT NULL,"+
                COLOUMN_MONEY+" INTEGER NOT NULL );")
    }
}