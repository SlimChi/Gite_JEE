package fr.cs.gite_jee.metier;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;

public class EquipementGite {

    private int idGite;

    private int idEquipement;

    private Equipement equipement;

    private float prix;

    public EquipementGite(){

    }


    public int getIdGite() {
        return idGite;
    }

    public void setIdGite(int idGite) {
        this.idGite = idGite;
    }

    public int getIdEquipement() {
        return idEquipement;
    }

    public void setIdEquipement(int idEquipement) {
        this.idEquipement = idEquipement;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }

    public float getPrix() {
        return prix;
    }

    public FloatProperty getPrixProperty(){
        return new SimpleFloatProperty(prix);
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return  equipement.toString();
    }


}
