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

    private ArrayList<Gite> allGites;
    private Gite giteSelected;

    private ServiceGite serviceGite;

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
}
