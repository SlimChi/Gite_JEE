package fr.cs.gite_jee.bean;

import fr.cs.gite_jee.dao.DaoFactory;
import fr.cs.gite_jee.metier.*;
import fr.cs.gite_jee.service.GiteSearch;
import fr.cs.gite_jee.service.ServiceGite;
import fr.cs.gite_jee.service.VilleSearch;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;

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

    private ArrayList<Departement> listDepartementSelected;
    private Departement departementSelected;
    private ArrayList<Gite> allGites;
    private ArrayList<Gite> allGitesSelected;
    private Gite giteSelected;
    private static ArrayList<SaisonGite> allSaisonGite;
    private SaisonGite saisonGiteSelected;

    private ServiceGite serviceGite;

    private GiteSearch giteSearch;

    private String idDepartements;

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
            gs.setIdDepartement(idDepartements);
        }


        if(villeSelected != null){

            gs.setVille(villeSelected);
        }

        allGites = DaoFactory.getGiteDAO().getLike(gs);


        listEquipementSelected = null;
        listRegionSelected = null;
        listDepartementSelected =null;
    }

    public void reset() {

        giteSearch = new GiteSearch();

        Equipement equipement = new Equipement();
        equipement.setLibelle("Choisir un equipement");
        equipement.setId(0);

        Departement departement = new Departement();
        departement.setNomDepartement("Choisir un departement");
        departement.setCodeInseeDept("");

        Region region = new Region();
        region.setNom("Choisir une region");
        region.setId(0);

        Ville ville = new Ville();
        ville.setNom("Ville");

        allDepartement.clear();

        allGites = DaoFactory.getGiteDAO().getLike(giteSearch);
        init();
    }

    public void departementToString(){

        int nb = listDepartementSelected.size();
        StringBuilder stringBuilder = new StringBuilder("");

            for (int i=0; i<nb;i++){
                if (i != (nb -1)) {
                    stringBuilder.append("'"+listDepartementSelected.get(i).getCodeInseeDept()+"',");
                }else {
                    stringBuilder.append("'"+listDepartementSelected.get(i).getCodeInseeDept()+"'");
                }
            }

        this.idDepartements = stringBuilder.toString();
    }

    private String regionToString(){
        int nb = listRegionSelected.size();
        StringBuilder stringBuilder = new StringBuilder("");
            for (int i=0; i<nb;i++){
                if (i != (nb - 1)) {
                    stringBuilder.append(listRegionSelected.get(i).getId()+",");
                }else{
                    stringBuilder.append(listRegionSelected.get(i).getId());
                }
            }
        return stringBuilder.toString();
    }

    private String equipementToString(){

        int nb = listEquipementSelected.size();
        StringBuilder stringBuilder = new StringBuilder("");

            for(int i=0;i<nb;i++){
                if(i != (nb-1)){
                    stringBuilder.append(listEquipementSelected.get(i).getId()+",");
                }else{
                    stringBuilder.append(listEquipementSelected.get(i).getId());
                }
            }


        return stringBuilder.toString();
    }
    public void NouveauGite() {
        giteSelected = new Gite();

    }

    public void deleteGite() {
        DaoFactory.getGiteDAO().delete(giteSelected);
        this.giteSelected = null;

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
        allGites = DaoFactory.getGiteDAO().getLike(giteSearch);
        PrimeFaces.current().ajax().update("form:gites");

    }

    public void saveGite() {
        if (giteSelected.getId() == 0) {
            try{
                DaoFactory.getGiteDAO().insert(giteSelected);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Gite ajouté"));
            } catch (Exception e){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erreur! gite non ajouté"));
            }

        }
        else {
            DaoFactory.getGiteDAO().update(giteSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Article mis à jour"));
        }
        PrimeFaces.current().ajax().update("form:gites");
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");

    }

    public void onRegionChange() {
        if (regionSelected.getId() != 0) {

           allDepartement = DaoFactory.getDepartementDAO().getByRegion(regionSelected.getId());

        } else {
            allDepartement = DaoFactory.getDepartementDAO().getAll();
            Departement departement = new Departement();
            allDepartement.add(0, departement);
        }
    }

    public void onDepartementChange() {
        if (departementSelected.getCodeInseeDept() != null) {

            regionSelected = DaoFactory.getRegionDAO().getByID(departementSelected.getRegion().getId());
            allRegion = new ArrayList<>();
            allRegion.add(departementSelected.getRegion());

        } else {

            allRegion = DaoFactory.getRegionDAO().getAll();
            Region region = new Region();
            allRegion.add(0, region);


        }
    }

    public void test(){
        System.out.println("test");
    }

    public ArrayList<Ville> villeSearch(String query){

        VilleSearch villeSearch = new VilleSearch();

        villeSearch.setNom(query);
        villeSearch.setIdDepartement(idDepartements);

        allVilles = DaoFactory.getVilleDAO().getLike(villeSearch);


        return allVilles;

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
        System.out.println("setGiteSelected");
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
