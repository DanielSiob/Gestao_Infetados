package com.example.gestaoinfetados;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
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
        Pacientes pacientes = Converte.cursorToPaciente(cursor);
        holder.setPacientes(pacientes);
    }

    @Override
    public int getItemCount() {
        if(cursor==null) {
            return 0;
        }
        return cursor.getCount();
    }
    
    private ViewHolderPacientes viewHolderPacientesSelecionado = null;
    

    public class ViewHolderPacientes extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Pacientes pacientes = null;

        private final TextView TVPatID, TVPatName, TVPatBday, TVPatDoe;
        public void setPacientes(Pacientes pacientes){

        }
        public ViewHolderPacientes(@NonNull View itemView) {
            super(itemView);
            TVPatID = (TextView) itemView.findViewById(R.id.TVPatID);
            TVPatName = (TextView) itemView.findViewById(R.id.TVPatName);
            TVPatBday = (TextView) itemView.findViewById(R.id.TVPatBday);
            TVPatDoe = (TextView) itemView.findViewById(R.id.TVPatDoe);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(viewHolderPacientesSelecionado == this){                 
                return;             
            }              
            if(viewHolderPacientesSelecionado != null){                 
                viewHolderPacientesSelecionado.desSelecionado();             
            }              
            viewHolderPacientesSelecionado = this;             
            seleciona();              
            RecyclerViewPacientes recyclerViewPacientes = (RecyclerViewPacientes) AdaptadorPacientes.this.context;         
        }

        private void seleciona() {
            itemView.setBackgroundResource(R.color.colorAccent);
        }

        private void desSelecionado() {
            itemView.setBackgroundResource(android.R.color.white);
        }
    }
}
