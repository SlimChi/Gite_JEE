package fr.cs.gite_jee.service;

import fr.cs.gite_jee.metier.*;

public class GiteSearch {

    private int id;
    private String nomDuGite;

    private Equipement equipement;

    private TypeEquipement typeEquipement;

    private Ville ville;

    private Departement departement;

    private Region region;

    public GiteSearch(){
        equipement = new Equipement();
        typeEquipement = new TypeEquipement();
        ville = new Ville();
        departement = new Departement();
        region = new Region();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomDuGite() {
        return nomDuGite;
    }

    public void setNomDuGite(String nomDuGite) {
        this.nomDuGite = nomDuGite;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }

    public TypeEquipement getTypeEquipement() {
        return typeEquipement;
    }

    public void setTypeEquipement(TypeEquipement typeEquipement) {
        this.typeEquipement = typeEquipement;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }


}