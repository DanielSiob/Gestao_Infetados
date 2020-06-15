package com.example.gestaoinfetados;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class Add_Patient_Data extends AppCompatActivity {

    private static final String TAG = "Add_Patient_Data";

    private TextView mTV;
    private Button mBtn;

    Calendar c;
    DatePickerDialog dpd;

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
    }
}
