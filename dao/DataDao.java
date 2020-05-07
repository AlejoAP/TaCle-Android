package com.example.hp.tacle.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hp.tacle.MyApplication;
import com.example.hp.tacle.dao.SQLiteHelper;
import com.example.hp.tacle.model.Commentaire;

import java.util.ArrayList;
import java.util.List;

/**public class DataDao {

    public static boolean addData (String item1){
        SQLiteDatabase db = MyApplication.getBd().getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLiteHelper.COL2, item1);

        long result = db.insert(SQLiteHelper.TABLE_NAME2, null, contentValues);

        if (result ==-1) {
            return false;
        }
        else {
            return true;
        }
    }

    public static List<Commentaire> getListContents(){
        SQLiteDatabase db = MyApplication.getBd().getWritableDatabase();
        List<Commentaire> liste = new ArrayList<>();
        Cursor data = db.query(SQLiteHelper.TABLE_NAME2,null, null, null, null, null, null);


        //Cursor cursor = bdd.query(TABLE_HISTORIQUES, new String[]{COL_ID, COL_SOCIETE,COL_TITRE,COL_DATE }, null,null,null,null,null);
        // looping through all rows and adding to list

        if (data.moveToFirst()) {
            do {
                Commentaire  commentaire = new Commentaire();
                commentaire.setId(data.getInt(data.getColumnIndex(SQLiteHelper.COL1)));
                commentaire.setDescription(data.getString(data.getColumnIndex(SQLiteHelper.COL2)));
                liste.add(commentaire);

            } while (data.moveToNext());
        }

        data.close();
        db.close();



        return liste;
    }

}*/
