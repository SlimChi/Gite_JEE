package fr.cs.gite_jee.metier;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Objects;

public class Departement {

    private String codeInseeDept;

    private String nomDepartement;

    private int idRegion;

    private Region region;

    public Departement() {

    }

    public Departement(String codeInseeDept, String nomDepartement, Region region){

        this.codeInseeDept = codeInseeDept;
        this.nomDepartement = nomDepartement;
        this.region = region;

    }

    public Departement(String codeInseeDept, String nomDepartement,int idRegion){
        this.codeInseeDept = codeInseeDept;
        this.nomDepartement = nomDepartement;
        this.idRegion = idRegion;
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


    public StringProperty getNomDepartementProperty(){
        return new SimpleStringProperty(nomDepartement);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departement that = (Departement) o;
        return codeInseeDept == that.codeInseeDept;
        //return idRegion == that.idRegion && codeInseeDept.equals(that.codeInseeDept) && nomDepartement.equals(that.nomDepartement) && region.equals(that.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeInseeDept, nomDepartement, idRegion);
    }

    @Override
    public String toString() {
        return  nomDepartement;
    }
}
