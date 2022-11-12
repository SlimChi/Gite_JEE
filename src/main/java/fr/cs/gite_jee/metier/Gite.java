package fr.cs.gite_jee.metier;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class Gite {

    private int id;

    private String nom;

    private int nombreChambre;

    private int nombreCouchage;

    private int surfaceHabitable;

    private String adresse;

    private String codeInseeDept;

    private String codeInsee;

    private int idPersonne;

    private Personne personne;

    private int idPersonneGerant;

    private Personne personneGerant;

    private Ville ville;

    private ArrayList<EquipementGite> equipementGites;

    private ArrayList<Disponibilite> disponibilites;

    private ArrayList<Telephone> telephones;

    private ArrayList<Mail> mails;

    private ArrayList<LocaliteVille> localiteVilles;

    private ArrayList<SaisonGite> saisonGites;

    private ArrayList<LocaliteSaisonPeriode> localiteSaisonPeriodes;


    public Gite() {

        this.personne = new Personne();
        this.personneGerant = new Personne();
        this.ville = new Ville();

    }

    public int getId() {
        return id;
    }

    public IntegerProperty getIdProperty(){

        return new SimpleIntegerProperty(id);
    }

    public void setId(int id) {
        this.id = id;
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

    public int getNombreChambre() {
        return nombreChambre;
    }
    public IntegerProperty getNombreChambreProperty() {
        return new SimpleIntegerProperty(nombreCouchage);
    }

    public void setNombreChambre(int nombreChambre) {
        this.nombreChambre = nombreChambre;
    }

    public IntegerProperty getNombreCouchargeProperty(){
        return new SimpleIntegerProperty(nombreCouchage);
    }

    public int getNombreCouchage() {
        return nombreCouchage;
    }

    public void setNombreCouchage(int nombreCouchage) {
        this.nombreCouchage = nombreCouchage;
    }

    public int getSurfaceHabitable() {
        return surfaceHabitable;
    }

    public void setSurfaceHabitable(int surfaceHabitable) {
        this.surfaceHabitable = surfaceHabitable;
    }

    public String getAdresse() {
        return adresse;
    }
    public StringProperty getAdresseroperty(){
        return new SimpleStringProperty(adresse);
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
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

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public int getIdPersonneGerant() {
        return idPersonneGerant;
    }

    public void setIdPersonneGerant(int idPersonneGerant) {
        this.idPersonneGerant = idPersonneGerant;
    }

    public Personne getPersonneGerant() {
        return personneGerant;
    }

    public void setPersonneGerant(Personne personneGerant) {
        this.personneGerant = personneGerant;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public ArrayList<EquipementGite> getEquipementGites() {
        return equipementGites;
    }

    public void setEquipementGites(ArrayList<EquipementGite> equipementGites) {
        this.equipementGites = equipementGites;
    }

    public ArrayList<Disponibilite> getDisponibilites() {
        return disponibilites;
    }

    public void setDisponibilites(ArrayList<Disponibilite> disponibilites) {
        this.disponibilites = disponibilites;
    }

    public ArrayList<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(ArrayList<Telephone> telephones) {
        this.telephones = telephones;
    }

    public ArrayList<Mail> getMails() {
        return mails;
    }

    public void setMails(ArrayList<Mail> mails) {
        this.mails = mails;
    }

    public ArrayList<LocaliteVille> getLocaliteVilles() {
        return localiteVilles;
    }

    public void setLocaliteVilles(ArrayList<LocaliteVille> localiteVilles) {
        this.localiteVilles = localiteVilles;
    }

    public ArrayList<SaisonGite> getSaisonGites() {
        return saisonGites;
    }

    public void setSaisonGites(ArrayList<SaisonGite> saisonGites) {
        this.saisonGites = saisonGites;
    }

    public ArrayList<LocaliteSaisonPeriode> getLocaliteSaisonPeriodes() {
        return localiteSaisonPeriodes;
    }

    public void setLocaliteSaisonPeriodes(ArrayList<LocaliteSaisonPeriode> localiteSaisonPeriodes) {
        this.localiteSaisonPeriodes = localiteSaisonPeriodes;
    }


}
