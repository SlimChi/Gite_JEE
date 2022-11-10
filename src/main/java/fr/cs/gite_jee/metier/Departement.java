package fr.cs.gite_jee.metier;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Departement {

    private String codeInseeDept;

    private String nomDepartement;

    private int idRegion;

    private Region region;

    public Departement(){

        region = new Region();

    }

    public String getCodeInseeDept() {
        return codeInseeDept;
    }

    public void setCodeInseeDept(String codeInseeDept) {
        this.codeInseeDept = codeInseeDept;
    }

    public String getNomDepartement() {
        return nomDepartement;
    }

    public StringProperty getNomDepartementProperty(){
        return new SimpleStringProperty(nomDepartement);
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
