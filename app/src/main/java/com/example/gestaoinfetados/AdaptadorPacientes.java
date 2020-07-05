package com.example.gestaoinfetados;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorPacientes extends RecyclerView.Adapter<AdaptadorPacientes.ViewHolderPacientes> {

    private final Context context;
    private Cursor cursor = null;

    public void setCursor(Cursor cursor) {
        if (cursor != this.cursor) {
            this.cursor = cursor;
            notifyDataSetChanged();
        }
    }
    public AdaptadorPacientes(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderPacientes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemPaciente = LayoutInflater.from(context).inflate(R.layout.itempacientes, parent, false);
        return new ViewHolderPacientes(itemPaciente);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPacientes holder, int position) {
        cursor.moveToPosition(position);
        Pacientes pacientes = Pacientes.cursorToDoente(cursor);
        holder.setDoentes(doentes);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderPacientes extends RecyclerView.ViewHolder {
        public ViewHolderPacientes(@NonNull View itemView) {
            super(itemView);
        }
    }
}
