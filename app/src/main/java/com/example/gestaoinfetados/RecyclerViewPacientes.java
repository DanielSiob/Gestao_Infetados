package com.example.gestaoinfetados;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

public class RecyclerViewPacientes extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    public static final String ID_PACIENTE = "ID_PACIENTE";
    private RecyclerView RecyclerViewPa;
    private AdaptadorPacientes adaptadorPacientes;
    public static final ID_CURSOR_LOADER_PA = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_pacientes);

        Intent intentVerTodosPa = getIntent();

        RecyclerViewPa = (RecyclerView)findViewById(R.id.RecyclerViewPa);
        adaptadorPacientes = new AdaptadorPacientes(this);
        RecyclerViewPa.setAdapter(adaptadorPacientes);
        RecyclerViewPa.setLayoutManager(new LinearLayoutManager(this));
        adaptadorPacientes.setCursor(null);
        LoaderManager.getInstance(this).initLoader(ID_CURSOR_LOADER_PA, null, this);

    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        return new CursorLoader(this, );
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

    }
}