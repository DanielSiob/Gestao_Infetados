package com.example.gestaoinfetados;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.ContactsContract;
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

public class Edit_Patient_Info extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView mTVEh;
    Button mBtnEh;
    TextView mTVAh;
    Button mBtnAh;
    TextView mTVObi;
    Button mBtnObi;

    Calendar c;
    DatePickerDialog dpd;

    Spinner spinner;

    TextInputEditText TIETid;
    TextView TextViewPickDateEntHosp, TVAltaHosp, TextViewPickDateDataObi, TVSin;

    Button _btnSave, _btnUpdate, _btnDelete;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__patient__info);

        mTVEh = (TextView)findViewById(R.id.TextViewPickDateEntHosp);
        mBtnEh = (Button)findViewById(R.id.btnPickDateEntHosp);

        mTVAh = (TextView)findViewById(R.id.TVAltaHosp);
        mBtnAh = (Button) findViewById(R.id.btnPickDateAltaHosp);

        mTVObi = (TextView)findViewById(R.id.TextViewPickDateDataObi);
        mBtnObi = (Button)findViewById(R.id.btnPickDateDataObi);


        //ESCOLHER DATA PARA ENTRADA HOSPITALAR

        mBtnEh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                c = Calendar.getInstance();
                int dia = c.get(Calendar.DAY_OF_MONTH);
                int mes = c.get(Calendar.MONTH);
                int ano = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(Edit_Patient_Info.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        mTVEh.setText(dayOfMonth + "/" + (month+1) + "/" + year);
                    }
                }, dia, mes, ano);
                    dpd.show();
            }
        });

        //ESCOLHER DATA PARA SAIDA HOSPITALAR
        mBtnAh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c = Calendar.getInstance();
                int dia = c.get(Calendar.DAY_OF_MONTH);
                int mes = c.get(Calendar.MONTH);
                int ano = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(Edit_Patient_Info.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        mTVAh.setText(dayOfMonth + "/" + (month+1) + "/" + year);
                    }
                }, dia, mes, ano);
                    dpd.show();
            }
        });
        //ESCOLHER DATA DE OBITO DO PACIENTE
        mBtnObi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                int dia = c.get(Calendar.DAY_OF_MONTH);
                int mes = c.get(Calendar.MONTH);
                int ano = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(Edit_Patient_Info.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        mTVObi.setText(dayOfMonth + "/" + (month+1) + "/" + year);
                    }
                }, dia, mes, ano);
                dpd.show();
            }
        });


        //SPINNER DOS SINTOMAS


        spinner = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sintomas, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);



        //BUSCAR ID
        TextViewPickDateEntHosp = findViewById(R.id.TextViewPickDateEntHosp);
        TVAltaHosp = findViewById(R.id.TVAltaHosp);
        TextViewPickDateDataObi = findViewById(R.id.TextViewPickDateDataObi);
        TVSin = findViewById(R.id.TVSin);
        _btnSave = findViewById(R.id.btnGuEditPatData);
        _btnUpdate = findViewById(R.id.btnUpEditPatData);
        _btnDelete = findViewById(R.id.btnDeEditPatData);
        openHelper = new DatabaseHelper(this);
        _btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String deh = TextViewPickDateEntHosp.getText().toString();
                String dah = TVAltaHosp.getText().toString();
                String dob = TextViewPickDateDataObi.getText().toString();
                String sin = TVSin.getText().toString();
                db = openHelper.getWritableDatabase();
                insertData(deh, dah, dob, sin);
                Toast.makeText(getApplicationContext(), "Data Added", Toast.LENGTH_LONG).show();
            }
        });

    }

    //CONTINUAÇÃO DO SPINNER
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        TVSin.setText(spinner.getSelectedItem().toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void insertData(String deh, String dah, String dob, String sin){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_5, deh);
        contentValues.put(DatabaseHelper.COL_6, dah);
        contentValues.put(DatabaseHelper.COL_7, dob);
        contentValues.put(DatabaseHelper.COL_8, sin);
        long id = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
    }
}