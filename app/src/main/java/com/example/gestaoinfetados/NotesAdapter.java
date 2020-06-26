package com.example.gestaoinfetados;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {
    private Context context;
    private List<Data> notesList;
    //private List<DataProf> notesList;


    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_recycler, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Data note = notesList.get(position);
        holder.id.setText(Integer.toString(note.getId()));
        //holder.nomeProf.setText(note.getSaveNomeProf());
        //holder.TVBirthProf.setText(note.getSavePickDate());
        //holder.TVWorkSect.setText(note.getSaveWorkSect);
        holder.TIETNomePat.setText(note.saveNomePat);
        holder.TIETDoeCont.setText(note.saveDoeCont);
        holder.TextViewPickDatePatient.setText(note.savePickDate);
        holder.TextViewPickDateEntHosp.setText(note.saveDateEntHosp);
        holder.TVAltaHosp.setText(note.saveDateAltHosp);
        holder.TextViewPickDateDataObi.setText(note.saveDateObi);
        holder.TVSin.setText(note.saveSin);
    }

    public NotesAdapter(Context context, List<Data> notesList){
        this.context = context;
        this.notesList = notesList;
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView id;
        public EditText nomeProf;
        public TextView TVBirthProf;
        public TextView TVWorkSect;
        public TextInputEditText TIETNomePat;
        public TextInputEditText TIETDoeCont;
        public TextView TextViewPickDatePatient;
        public TextView TextViewPickDateEntHosp;
        public TextView TVAltaHosp;
        public TextView TextViewPickDateDataObi;
        public TextView TVSin;

        public MyViewHolder(@NonNull View view) {
            super(view);
            id = view.findViewById(R.id.id);
            nomeProf = view.findViewById(R.id.nomeProf);
            TVBirthProf = view.findViewById(R.id.TVBirthProf);
            TVWorkSect = view.findViewById(R.id.TVWorkSect);
            TIETNomePat = view.findViewById(R.id.TIETNomePat);
            TIETDoeCont = view.findViewById(R.id.TIETDoeCont);
            TextViewPickDatePatient = view.findViewById(R.id.TextViewPickDatePatient);
            TextViewPickDateEntHosp = view.findViewById(R.id.TextViewPickDateEntHosp);
            TVAltaHosp = view.findViewById(R.id.TVAltaHosp);
            TextViewPickDateDataObi = view.findViewById(R.id.TextViewPickDateDataObi);
            TVSin = view.findViewById(R.id.TVSin);
        }
    }
}
