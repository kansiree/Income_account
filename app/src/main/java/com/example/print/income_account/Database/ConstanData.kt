package com.example.print.income_account.Database

import android.provider.BaseColumns

/**
 * Created by print on 9/25/2017.
 */
public interface ConstanData : BaseColumns {
    public val Table_Name: String get() = "TABLE_NAME"
    public val COLOUMN_ID:String get() = "ID"
    public val COLOUMN_TYPE:String get() = "TYPE"
    public val COLOUMN_DATE:String get() = "DATE"
    public val COLOUMN_MENU:String get() = "MENU"
    public val COLOUMN_MONEY:String get() = "MONEY"
}