package com.example.hp.tacle.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    static String DATABASE_NAME="examDataBase";

    public static final String KEY_ID="id";

    public static final String TABLE_NAME="login";

    public static final String KEY_lnm="lnm";

    public static final String KEY_fnm="fnm";

    public static final String KEY_unm="unm";

    public static final String KEY_pwd="pwd";


    public static final String TABLE_NAME2="mylist_data";

    public static final String COL2 = "ITEM1";


    public SQLiteHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        String  table1 ="CREATE TABLE "+TABLE_NAME+" ("+KEY_ID+" INTEGER PRIMARY KEY, "+KEY_lnm+" VARCHAR, "+KEY_fnm+" VARCHAR, "+KEY_unm+" VARCHAR, "+KEY_pwd+" VARCHAR)";
        //database.execSQL(CREATE_TABLE);
        String table2 = "CREATE TABLE " + TABLE_NAME2 +" ("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COL2+" TEXT)";
        String  createTable = table1+table2 ;
        database.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME+TABLE_NAME2);
        onCreate(db);

    }

    public boolean insertData(String KEY_ID, String COL2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ITEM1", COL2);

        Long result = db.insert("TABLE_NAME2", null, contentValues);

        if (result == -1) return false;
        else
            return true;
    }

}