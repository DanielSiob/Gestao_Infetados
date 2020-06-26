package com.example.gestaoinfetados;

public class DataProf {
    int id;
    String saveNomeProf;
    String saveBirthProf;
    String saveWorkSect;



    //CRIAÇÃO DA TABELA (QUERY)
    public static final String CREATE_TABLE2 =
            "Create Table " + "Professional" + "(" + "Id" + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "Name" + "Text,"+
                    "Birthday" + "Text,"+
                    "Work Section" + "Text,"+ ")";






    public DataProf(int id, String saveNomeProf, String saveBirthProf, String saveWorkSect) {
        this.id = id;
        this.saveNomeProf = saveNomeProf;
        this.saveBirthProf = saveBirthProf;
        this.saveWorkSect = saveWorkSect;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSaveNomeProf() {
        return saveNomeProf;
    }

    public void setSaveNomeProf(String saveNomeProf) {
        this.saveNomeProf = saveNomeProf;
    }

    public String getSaveBirthProf() {
        return saveBirthProf;
    }

    public void setSaveBirthProf(String saveBirthProf) {
        this.saveBirthProf = saveBirthProf;
    }

    public String getSaveWorkSect() {
        return saveWorkSect;
    }

    public void setSaveWorkSect(String saveWorkSect) {
        this.saveWorkSect = saveWorkSect;
    }
}
