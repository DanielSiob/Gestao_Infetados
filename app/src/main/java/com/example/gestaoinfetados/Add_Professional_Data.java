package com.example.gestaoinfetados;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
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

    DatabaseHelper db;


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
        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.seccao, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        db = new DatabaseHelper(this);

        //BUSCAR ID's
        nomeProf = findViewById(R.id.nomeProf);
        TVBirthProf = findViewById(R.id.TVBirthProf);
        TVWorkSect = findViewById(R.id.TVWorkSect);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void saveAddProf(View view){
        String saveNomeProf = nomeProf.getText().toString();
        String saveBirthProf = TVBirthProf.getText().toString();
        String saveWorkSect = TVWorkSect.getText().toString();
    }

}
