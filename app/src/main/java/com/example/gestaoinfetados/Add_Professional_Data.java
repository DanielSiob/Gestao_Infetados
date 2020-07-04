package com.example.gestaoinfetados;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class Add_Professional_Data extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    TextView mTVN;
    Button mBtnN;

    Calendar c;
    DatePickerDialog dpd;

    EditText nomeProf;
    TextView TVBirthProf, TVWorkSect;

    Spinner spinner;

    Button _btnSave, _btnUpdate, _btnDelete;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__professional__data);

        mTVN = (TextView)findViewById(R.id.TVBirthProf);
        mBtnN = (Button)findViewById(R.id.btnPickDateOfBirthProf);


        //ESCOLHER DATA DE NASCIMENTO DOS PROFISSIONAIS
        mBtnN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                int dia = c.get(Calendar.DAY_OF_MONTH);
                int mes = c.get(Calendar.MONTH);
                int ano = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(Add_Professional_Data.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        mTVN.setText(dayOfMonth + "/" + (month+1) + "/" + year);
                    }
                }, dia, mes, ano);
                dpd.show();
            }
        });


        //SPINNER DA SECÇÃO DOS TRABALHOS DOS PROFISSIONAIS
        spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.seccao, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        //BUSCAR ID's
        nomeProf = findViewById(R.id.nomeProf);
        TVBirthProf = findViewById(R.id.TVBirthProf);
        TVWorkSect = findViewById(R.id.TVWorkSect);
        _btnSave = (Button)findViewById(R.id.btnGuAddProfData);
        _btnUpdate = (Button)findViewById(R.id.btnUpAddProfData);
        _btnDelete = (Button)findViewById(R.id.btnDeAddProfData);
        openHelper = new DatabaseHelper(this);
        _btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = nomeProf.getText().toString();
                String dataNas = TVBirthProf.getText().toString();
                String sec = TVWorkSect.getText().toString();
                db = openHelper.getWritableDatabase();
                insertData(nome, dataNas, sec);
                Toast.makeText(getApplicationContext(), "Data Added", Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        TVWorkSect.setText(spinner.getSelectedItem().toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void insertData(String nome, String dataNas, String sec){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL2, nome);
        contentValues.put(DatabaseHelper.COL3, dataNas);
        contentValues.put(DatabaseHelper.COL4, sec);
        long id = db.insert(DatabaseHelper.TABLE_NAME2, null, contentValues);
    }
}
