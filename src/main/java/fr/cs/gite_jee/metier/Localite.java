package fr.cs.gite_jee.metier;

public class Localite {

    private int id;

    private String libelle;



    public Localite() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }



    @Override
    public String toString() {
        return libelle;
    }
}
