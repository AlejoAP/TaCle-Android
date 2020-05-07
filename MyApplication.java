package com.example.hp.tacle;

import android.app.Application;

import com.example.hp.tacle.dao.SQLiteHelper;
import com.facebook.stetho.Stetho;

public class MyApplication  extends Application {
    private static SQLiteHelper bd;
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        bd = new SQLiteHelper(this);

    }

    public static SQLiteHelper getBd() {
        return bd;
    }

    public static void setBd(SQLiteHelper bd) {
        MyApplication.bd = bd;
    }
}
