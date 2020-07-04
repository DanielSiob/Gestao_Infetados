package com.example.gestaoinfetados;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class Add_Patient_Data extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = "Add_Patient_Data";

    private TextView mTV;
    private Button mBtn;

    Calendar c;
    DatePickerDialog dpd;

    TextInputEditText TIETNomePat, TIETDoeCont, TIETid;
    TextView TextViewPickDatePatient;

    Button _btnSave, _btnUpdate, _btnDelete;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__patient__data);

        mTV = (TextView) findViewById(R.id.TextViewPickDatePatient);
        mBtn = (Button) findViewById(R.id.btnPickDatePatient);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c = Calendar.getInstance();
                int ano = c.get(Calendar.YEAR);
                int mes = c.get(Calendar.MONTH);
                int dia = c.get(Calendar.DAY_OF_MONTH);

                dpd = new DatePickerDialog(Add_Patient_Data.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        mTV.setText(dayOfMonth + "/" + (month+1) + "/" + year);
                    }
                }, dia, mes, ano);
                dpd.show();
            }
        });


        //BUSCAR ID's
        TIETid = (TextInputEditText) findViewById(R.id.TIETid);
        TIETNomePat = (TextInputEditText)findViewById(R.id.TIETNomePat);
        TIETDoeCont = (TextInputEditText)findViewById(R.id.TIETDoeCont);
        TextViewPickDatePatient =(TextView)findViewById(R.id.TextViewPickDatePatient);
        _btnSave = (Button)findViewById(R.id.btnGuAddPatData);
        _btnUpdate = (Button)findViewById(R.id.btnUpAddPatData);
        _btnDelete = (Button)findViewById(R.id.btnDeAddPatData);
        openHelper = new DatabaseHelper(this);
        _btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = TIETNomePat.getText().toString();
                String dataNas = TextViewPickDatePatient.getText().toString();
                String doe = TIETDoeCont.getText().toString();
                db = openHelper.getWritableDatabase();
                insertData(nome, dataNas, doe);
                Toast.makeText(getApplicationContext(), "Data Added", Toast.LENGTH_LONG).show();
            }
        });

        _btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = openHelper.getWritableDatabase();
                String id = TIETid.getText().toString();
                deleteData(id);
                Toast.makeText(getApplicationContext(), "Data Deleted", Toast.LENGTH_LONG).show();
            }
        });

        _btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = TIETNomePat.getText().toString();
                String dataNas = TextViewPickDatePatient.getText().toString();
                String doe = TIETDoeCont.getText().toString();
                db = openHelper.getWritableDatabase();
                updateData(nome, dataNas, doe);
                Toast.makeText(getApplicationContext(), "Data Updated", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void insertData(String nome, String dataNas, String doe){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2, nome);
        contentValues.put(DatabaseHelper.COL_3, dataNas);
        contentValues.put(DatabaseHelper.COL_4, doe);
        long id = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
    }

    public boolean deleteData(String id){
        return db.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper.COL_1 + "=?", new String[]{id})>0;
    }

    public boolean updateData(String nome, String dataNas, String doe){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2, nome);
        contentValues.put(DatabaseHelper.COL_3, dataNas);
        contentValues.put(DatabaseHelper.COL_4, doe);
        String id = TIETid.getText().toString();
        return db.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper.COL_1 +"=?", new String[]{id})>0;
    }
}
