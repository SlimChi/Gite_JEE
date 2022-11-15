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
    private ArrayList<Equipement> listEquipementSelected;

    private static ArrayList<TypeEquipement> allTypeEquipements;
    private TypeEquipement typeEquipementSelected;

    private static ArrayList<Ville> allVilles;
    private Ville villeSelected;
    private ArrayList<Ville> listVilleSelected;

    private static ArrayList<Region> allRegion;
    private Region regionSelected;
    private ArrayList<Region> listRegionSelected;

    private static ArrayList<Departement> allDepartement;
    private Departement departementSelected;
    private ArrayList<Departement> listDepartementSelected;

    private ArrayList<Gite> allGites;
    private ArrayList<Gite> allGitesSelected;
    private Gite giteSelected;
    private static ArrayList<SaisonGite> allSaisonGite;
    private SaisonGite saisonGiteSelected;

    private ServiceGite serviceGite;

    private GiteSearch giteSearch;

    @PostConstruct
    private void init() {


        Equipement equipement = new Equipement();
        equipement.setLibelle("Choisir un equipement");
        equipement.setId(0);

        allEquipements = DaoFactory.getEquipementDAO().getAll();
        allEquipements.add(0,equipement);

        Region region = new Region();
        region.setNom("Choisir une region");
        region.setId(0);


        allRegion = DaoFactory.getRegionDAO().getAll();
        allRegion.add(0, region);

        Departement departement = new Departement();
        departement.setNomDepartement("Choisir un departement");
        departement.setCodeInseeDept("");

        allDepartement = DaoFactory.getDepartementDAO().getAll();
        allDepartement.add(0,departement);

        Ville ville = new Ville();
        ville.setNom("Choisir une ville");


        allVilles = DaoFactory.getVilleDAO().getAll();
        allVilles.add(0,ville);


        GiteSearch giteSearch = new GiteSearch();


        allGites= DaoFactory.getGiteDAO().getLike(giteSearch);

    }

    public void filtrer(){

        GiteSearch gs= new GiteSearch();

        if(listEquipementSelected.size() != 0){
            gs.setNbEquipements(listEquipementSelected.size());
            gs.setIdEquipements(equipementToString());
        }

        if (listRegionSelected.size() != 0){
            gs.setNbRegion(listRegionSelected.size());
            gs.setIdRegion(regionToString());
        }

        if (listDepartementSelected.size() != 0){
            gs.setNbDepartement(listDepartementSelected.size());
            gs.setIdDepartement(departementToString());
        }


        allGites = DaoFactory.getGiteDAO().getLike(gs);


        listEquipementSelected = null;
        listRegionSelected = null;
        listDepartementSelected =null;
    }

    public void reset() {
        init();
        giteSearch = new GiteSearch();

        allGites = DaoFactory.getGiteDAO().getLike(giteSearch);
        Equipement equipement = new Equipement();
        equipement.setLibelle("Choisir un equipement");
        equipement.setId(0);

    }

    private String departementToString(){
        int nb = listDepartementSelected.size();
        StringBuilder stringBuilder = new StringBuilder("");
        if (nb> 1 ){
            for (int i=0; i<nb;i++){
                if (i != (nb -1)) {
                    stringBuilder.append(listDepartementSelected.get(i).getCodeInseeDept()+"");
                }else {
                    stringBuilder.append(listDepartementSelected.get(i).getCodeInseeDept());
                }
            }
        }else {
            stringBuilder.append(listDepartementSelected.get(0).getCodeInseeDept());
        }
        return stringBuilder.toString();
    }

    private String regionToString(){
        int nb = listRegionSelected.size();
        StringBuilder stringBuilder = new StringBuilder("");
        if (nb> 1){
            for (int i=0; i<nb;i++){
                if (i != (nb - 1)) {
                    stringBuilder.append(listRegionSelected.get(i).getId()+",");
                }else{
                    stringBuilder.append(listRegionSelected.get(i).getId());
                }
            }
        }else {
            stringBuilder.append(listRegionSelected.get(0).getId());
        }
        return stringBuilder.toString();
    }

    private String equipementToString(){

        int nb = listEquipementSelected.size();
        StringBuilder stringBuilder = new StringBuilder("");

        if( nb> 1){

            for(int i=0;i<nb;i++){
                if(i != (nb-1)){
                    stringBuilder.append(listEquipementSelected.get(i).getId()+",");
                }else{
                    stringBuilder.append(listEquipementSelected.get(i).getId());
                }
            }

        }else{
            stringBuilder.append(listEquipementSelected.get(0).getId());
        }


        return stringBuilder.toString();
    }

    public ArrayList<Departement> getListDepartementSelected() {
        return listDepartementSelected;
    }

    public void setListDepartementSelected(ArrayList<Departement> listDepartementSelected) {
        this.listDepartementSelected = listDepartementSelected;
    }

    public ArrayList<Equipement> getAllEquipements() {
        return allEquipements;
    }

    public static void setAllEquipements(ArrayList<Equipement> allEquipements) {
        GiteBean.allEquipements = allEquipements;
    }

    public ArrayList<Region> getAllRegion() {
        return allRegion;
    }

    public static void setAllRegion(ArrayList<Region> allRegion) {
        GiteBean.allRegion = allRegion;
    }

    public ArrayList<Ville> getAllVilles() {
        return allVilles;
    }

    public static void setAllVilles(ArrayList<Ville> allVilles) {
        GiteBean.allVilles = allVilles;
    }

    public Equipement getEquipementSelected() {
        return equipementSelected;
    }

    public void setEquipementSelected(Equipement equipementSelected) {
        this.equipementSelected = equipementSelected;
    }

    public Ville getVilleSelected() {
        return villeSelected;
    }

    public void setVilleSelected(Ville villeSelected) {
        this.villeSelected = villeSelected;
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

    public ArrayList<Equipement> getListEquipementSelected() {
        return listEquipementSelected;
    }

    public void setListEquipementSelected(ArrayList<Equipement> listEquipementSelected) {
        this.listEquipementSelected = listEquipementSelected;
    }

    public ArrayList<Region> getListRegionSelected() {
        return listRegionSelected;
    }

    public void setListRegionSelected(ArrayList<Region> listRegionSelected) {
        this.listRegionSelected = listRegionSelected;
    }

    public ArrayList<Ville> getListVilleSelected() {
        return listVilleSelected;
    }

    public void setListVilleSelected(ArrayList<Ville> listVilleSelected) {
        this.listVilleSelected = listVilleSelected;
    }
}
