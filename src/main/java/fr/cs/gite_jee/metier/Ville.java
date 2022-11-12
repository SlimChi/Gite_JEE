package fr.cs.gite_jee.metier;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Objects;

public class Ville {

    private String nom;

    private Float latitude;

    private Float longitude;

    private String codeInseeDept;

    private String codeInsee;

    private Departement departement;


    public Ville(){

        this.departement = new Departement();

    }

    public String getNom() {
        return nom;
    }

    public StringProperty getNomProperty(){
        return new SimpleStringProperty(nom);
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getCodeInseeDept() {
        return codeInseeDept;
    }

    public void setCodeInseeDept(String codeInseeDept) {
        this.codeInseeDept = codeInseeDept;
    }

    public String getCodeInsee() {
        return codeInsee;
    }

    public void setCodeInsee(String codeInsee) {
        this.codeInsee = codeInsee;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ville ville = (Ville) o;
        return codeInsee.equals(ville.codeInsee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeInsee);
    }
}
