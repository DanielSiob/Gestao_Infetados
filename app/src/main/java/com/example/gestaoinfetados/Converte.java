package com.example.gestaoinfetados;

import android.database.Cursor;

public class Converte {
    public static Pacientes cursorToPaciente(Cursor cursor){
        Pacientes pacientes = new Pacientes();
        pacientes.setId((int) cursor.getLong(cursor.getColumnIndex(DatabaseHelper.COL_1)));
        pacientes.setNome(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_2)));
        pacientes.setDataNas(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_3)));
        pacientes.setDoe(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_4)));
        return pacientes;
    }
}
