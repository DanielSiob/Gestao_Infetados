package com.example.gestaoinfetados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "GesInf.db";
    public static final String TABLE_NAME = "PAT";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "nome";
    public static final String COL_3 = "dataNas";
    public static final String COL_4 = "doe";
    public static final String COL_5 = "deh";
    public static final String COL_6 = "dah";
    public static final String COL_7 = "dob";
    public static final String COL_8 = "sin";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table1 = "CREATE TABLE " +TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, dataNas TEXT, doe TEXT, deh TEXT, dah TEXT, do TEXT, sin TEXT)";
        db.execSQL(table1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}
