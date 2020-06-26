package com.example.gestaoinfetados;

public class Data {
    int id;
    String saveNomePat;
    String saveDoeCont;
    String savePickDate;
    String saveDateEntHosp;
    String saveDateAltHosp;
    String saveDateObi;
    String saveSin;

    public Data(){

    }


    //CRIAÇÃO DA TABELA (QUERY)
    public static final String CREATE_TABLE =
            "Create Table " + "Patient" + "(" + "Id" + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "Name" + "Text,"+
                    "Birthday" + "Text,"+
                    "Diseases" + "Text,"+
                    "DateEntryHospital" + "Text,"+
                    "DateDischargeHospital" + "Text,"+
                    "DateDeath" + "Text,"+
                    "Symptoms" + "Text,"+ ")";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSaveNomePat() {
        return saveNomePat;
    }

    public void setSaveNomePat(String saveNomeProf) {
        this.saveNomePat = saveNomePat;
    }

    public String getSaveDoeCont() {
        return saveDoeCont;
    }

    public void setSaveDoeCont(String saveDoeCont) {
        this.saveDoeCont = saveDoeCont;
    }

    public String getSavePickDate() {
        return savePickDate;
    }

    public void setSavePickDate(String savePickDate) {
        this.savePickDate = savePickDate;
    }

    public String getSaveDateEntHosp() {
        return saveDateEntHosp;
    }

    public void setSaveDateEntHosp(String saveDateEntHosp) {
        this.saveDateEntHosp = saveDateEntHosp;
    }

    public String getSaveDateAltHosp() {
        return saveDateAltHosp;
    }

    public void setSaveDateAltHosp(String saveDateAltHosp) {
        this.saveDateAltHosp = saveDateAltHosp;
    }

    public String getSaveDateObi() {
        return saveDateObi;
    }

    public void setSaveDateObi(String saveDateObi) {
        this.saveDateObi = saveDateObi;
    }

    public String getSaveSin() {
        return saveSin;
    }

    public void setSaveSin(String saveSin) {
        this.saveSin = saveSin;
    }

    public Data(int id, String saveNomePat, String saveDoeCont, String savePickDate, String saveDateEntHosp, String saveDateAltHosp, String saveDateObi, String saveSin) {
        this.id = id;
        this.saveNomePat = saveNomePat;
        this.saveDoeCont = saveDoeCont;
        this.savePickDate = savePickDate;
        this.saveDateEntHosp = saveDateEntHosp;
        this.saveDateAltHosp = saveDateAltHosp;
        this.saveDateObi = saveDateObi;
        this.saveSin = saveSin;
    }
}
