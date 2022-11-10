package fr.cs.gite_jee.bean;

import fr.cs.gite_jee.dao.DaoFactory;
import fr.cs.gite_jee.metier.*;
import fr.cs.gite_jee.service.GiteSearch;
import fr.cs.gite_jee.service.ServiceGite;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;

@Named
@SessionScoped
public class GiteBean implements Serializable {



    private static ArrayList<Equipement> allEquipements;
    private Equipement equipementSelected;

    private static ArrayList<TypeEquipement> allTypeEquipements;
    private TypeEquipement typeEquipementSelected;

    private static ArrayList<Ville> allVilles;
    private Ville villeSelected;

    private static ArrayList<Region> allRegion;
    private Region regionSelected;

    private static ArrayList<Departement> allDepartement;
    private Departement departementSelected;

    private ArrayList<Gite> allGites;
    private ArrayList<Gite> allGitesSelected;
    private Gite giteSelected;

    private ServiceGite serviceGite;

    private GiteSearch giteSearch;

    @PostConstruct
    private void init() {


        Equipement equipement = new Equipement();
        equipement.setLibelle("Choisir un equipement");
        equipement.setId(0);

       allEquipements = DaoFactory.getEquipementDAO().getAll();
       allEquipements.add(0,equipement);

        GiteSearch giteSearch = new GiteSearch();
        giteSearch.setNomDuGite("");
        Equipement e = new Equipement();
        e.setId(0);
        giteSearch.setEquipement(e);

        TypeEquipement typeEquipement = new TypeEquipement();
        typeEquipement.setId(0);
        giteSearch.setTypeEquipement(typeEquipement);

        Region region = new Region();
        region.setId(0);
        giteSearch.setRegion(region);

        Ville ville = new Ville();
        ville.setCodeInsee("");
        giteSearch.setVille(ville);

        Departement departement = new Departement();
        departement.setCodeInseeDept("");
        giteSearch.setDepartement(departement);

        allGites= DaoFactory.getGiteDAO().getLike(giteSearch);




    }


    public ArrayList<Equipement> getAllEquipements() {
        return allEquipements;
    }

    public static void setAllEquipements(ArrayList<Equipement> allEquipements) {
        GiteBean.allEquipements = allEquipements;
    }

    public Equipement getEquipementSelected() {
        return equipementSelected;
    }

    public void setEquipementSelected(Equipement equipementSelected) {
        this.equipementSelected = equipementSelected;
    }

    public ArrayList<TypeEquipement> getAllTypeEquipements() {
        return allTypeEquipements;
    }

    public static void setAllTypeEquipements(ArrayList<TypeEquipement> allTypeEquipements) {
        GiteBean.allTypeEquipements = allTypeEquipements;
    }

    public TypeEquipement getTypeEquipementSelected() {
        return typeEquipementSelected;
    }

    public void setTypeEquipementSelected(TypeEquipement typeEquipementSelected) {
        this.typeEquipementSelected = typeEquipementSelected;
    }

    public ArrayList<Ville> getAllVilles() {
        return allVilles;
    }

    public static void setAllVilles(ArrayList<Ville> allVilles) {
        GiteBean.allVilles = allVilles;
    }

    public Ville getVilleSelected() {
        return villeSelected;
    }

    public void setVilleSelected(Ville villeSelected) {
        this.villeSelected = villeSelected;
    }

    public ArrayList<Region> getAllRegion() {
        return allRegion;
    }

    public static void setAllRegion(ArrayList<Region> allRegion) {
        GiteBean.allRegion = allRegion;
    }

    public Region getRegionSelected() {
        return regionSelected;
    }

    public void setRegionSelected(Region regionSelected) {
        this.regionSelected = regionSelected;
    }

    public ArrayList<Departement> getAllDepartement() {
        return allDepartement;
    }

    public static void setAllDepartement(ArrayList<Departement> allDepartement) {
        GiteBean.allDepartement = allDepartement;
    }

    public Departement getDepartementSelected() {
        return departementSelected;
    }

    public void setDepartementSelected(Departement departementSelected) {
        this.departementSelected = departementSelected;
    }

    public ArrayList<Gite> getAllGites() {
        return allGites;
    }

    public void setAllGites(ArrayList<Gite> allGites) {
        this.allGites = allGites;
    }

    public Gite getGiteSelected() {
        return giteSelected;
    }

    public void setGiteSelected(Gite giteSelected) {
        this.giteSelected = giteSelected;
    }

    public ArrayList<Gite> getAllGitesSelected() {
        return allGitesSelected;
    }

    public void setAllGitesSelected(ArrayList<Gite> allGitesSelected) {
        this.allGitesSelected = allGitesSelected;
    }
}
