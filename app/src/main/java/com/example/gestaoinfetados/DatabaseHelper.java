package com.example.gestaoinfetados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 99;
    private static final String DATABASE_NAME = "Patient";
    private static final int DATABASE_VERSION2 = 1;
    private static final String DATABASE_NAME2 = "Professional";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Data.CREATE_TABLE);
        db.execSQL(DataProf.CREATE_TABLE2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertData(String TextViewPickDateEntHosp, String TVAltaHosp, String TextViewPickDateDataObi, String TVSin/*, String TIETNomePat, String TIETDoeCont, String TextViewPickDatePatient*/){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("HospitalEntry", TextViewPickDateEntHosp);
        values.put("HospitalDischarge", TVAltaHosp);
        values.put("DateDeath", TextViewPickDateDataObi);
        values.put("Symptoms", TVSin);
        //
        long id = db.insert("Patient", null, values);
        db.close();
        return id;
    }

    public long insertData2( String TIETNomePat, String TIETDoeCont, String TextViewPickDatePatient){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Patient Name", TIETNomePat);
        values.put("Previously Contracted Diseases", TIETDoeCont);
        values.put("Patient Birthday", TextViewPickDatePatient);
        long id = db.insert("Patient", null, values);
        db.close();
        return id;
    }

    public long insertData3( String nomeProf, String TVBirthProf, String TVWorkSect){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Professional Name", nomeProf);
        values.put("Professional Birthday", TVBirthProf);
        values.put("Work Section", TVWorkSect);
        long id = db.insert("Professional", null, values);
        db.close();
        return id;
    }

    public List<Data> getDataFromDB(){
        List<Data> note = new ArrayList<>();
        String query = "Select * From " +"Patient";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                Data data = new Data();
                data.setId(cursor.getInt(cursor.getColumnIndex("Id")));
                data.setSaveDateAltHosp(cursor.getString(cursor.getColumnIndex("DateDischargeHospital")));
                data.setSaveDateEntHosp(cursor.getString(cursor.getColumnIndex("DateEntryHospital")));
                data.setSaveDateObi(cursor.getString(cursor.getColumnIndex("DateDeath")));
                data.setSaveDoeCont(cursor.getString(cursor.getColumnIndex("Diseases")));
                data.setSaveNomePat(cursor.getString(cursor.getColumnIndex("Name")));
                data.setSavePickDate(cursor.getString(cursor.getColumnIndex("Birthday")));
                data.setSaveSin(cursor.getString(cursor.getColumnIndex("Symptoms")));
                note.add(data);
            }while (cursor.moveToNext());
        }
        db.close();
        return note;
    }
}
