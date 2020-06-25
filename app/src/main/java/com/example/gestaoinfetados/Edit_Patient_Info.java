package com.example.gestaoinfetados;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

    TextView TextViewPickDateEntHosp, TVAltaHosp, TextViewPickDateDataObi, TVSin;
    DatabaseHelper db;

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

        Spinner spinner = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sintomas, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        db = new DatabaseHelper(this);

        //BUSCAR ID
        TextViewPickDateEntHosp = findViewById(R.id.TextViewPickDateEntHosp);
        TVAltaHosp = findViewById(R.id.TVAltaHosp);
        TextViewPickDateDataObi = findViewById(R.id.TextViewPickDateDataObi);
        TVSin = findViewById(R.id.TVSin);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void saveEditPat(View view){
        String saveDateEntHosp = TextViewPickDateEntHosp.getText().toString();
        String saveDateAltHosp = TVAltaHosp.getText().toString();
        String saveDateObi = TextViewPickDateDataObi.getText().toString();
        String saveSin = TVSin.getText().toString();

        db.insertData(saveDateEntHosp, saveDateAltHosp, saveDateObi, saveSin);
    }
}