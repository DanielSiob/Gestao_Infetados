package com.example.gestaoinfetados;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class Edit_Patient_Info extends AppCompatActivity {

    private static final String TAG = "Edit_Patient_Info";

    private TextView mTVEH;
    private Button mBtnEH;

    Calendar c;
    DatePickerDialog dpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__patient__info);

        mTVEH = (TextView) findViewById(R.id.TextViewPickDateEntradaHospitalar);
        mBtnEH = (Button) findViewById(R.id.btnPickDateEntradaHospitalar);

        mBtnEH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c = Calendar.getInstance();
                int ano = c.get(Calendar.YEAR);
                int mes = c.get(Calendar.MONTH);
                int dia = c.get(Calendar.DAY_OF_MONTH);

                dpd = new DatePickerDialog(Edit_Patient_Info.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        mTVEH.setText(dayOfMonth + "/" + (month+1) + "/" + year);
                    }
                }, dia, mes, ano);
                dpd.show();
            }

        });
    }
}
