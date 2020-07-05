package com.example.gestaoinfetados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper2 extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "GesInf.db";
    public static final String TABLE_NAME2 = "PROF";
    public static final String COL1 = "IDPr";
    public static final String COL2 = "nomePr";
    public static final String COL3 = "dataNasPr";
    public static final String COL4 = "secPr";

    public DatabaseHelper2(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table2 = "CREATE TABLE " +TABLE_NAME2+ "(IDPr INTEGER PRIMARY KEY AUTOINCREMENT, nomePr TEXT, dataNasPr TEXT, secPr TEXT)";
        db.execSQL(table2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME2);
        onCreate(db);
    }
}
