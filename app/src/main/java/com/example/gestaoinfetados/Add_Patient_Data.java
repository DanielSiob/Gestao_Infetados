package com.example.gestaoinfetados;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
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

    TextInputEditText TIETNomePat, TIETDoeCont;
    TextView TextViewPickDatePatient;
    DatabaseHelper db;

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



        db = new DatabaseHelper(this);

        //BUSCAR ID's
        TIETNomePat = findViewById(R.id.TIETNomePat);
        TIETDoeCont = findViewById(R.id.TIETDoeCont);
        TextViewPickDatePatient = findViewById(R.id.TextViewPickDatePatient);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void saveAddPat(View view){
        String saveNomePat = TIETNomePat.getText().toString();
        String saveDoeCont = TIETDoeCont.getText().toString();
        String savePickDate = TextViewPickDatePatient.getText().toString();

        db.insertData2(saveNomePat, saveDoeCont, savePickDate);
        Intent intent = new Intent(Add_Patient_Data.this, RecyclerViewActivity.class);
        startActivity(intent);
    }

}
