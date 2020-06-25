package com.example.gestaoinfetados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    public void goToActivity_Add_Professional_Data (View view){
        Intent intent = new Intent (this, Add_Professional_Data.class);
        startActivity(intent);
    }

    public void goToActivity_Add_Patient_Data (View view){
        Intent intent = new Intent (this, Add_Patient_Data.class);
        startActivity(intent);
    }

    public void goToActivity_Edit_Patient_Info (View view){
        Intent intent = new Intent (this, Edit_Patient_Info.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
