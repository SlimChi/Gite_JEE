package fr.cs.gite_jee.bean;

import fr.cs.gite_jee.metier.Localite;
import fr.cs.gite_jee.metier.Ville;
import fr.cs.gite_jee.service.ServiceGite;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;

@Named
@SessionScoped
public class GiteBean implements Serializable {

    private static ArrayList<Ville> allVilles;
    private Ville villeSelected;

    private static ArrayList<Localite> allLocalites;
    private Localite localiteSelected;

    private ServiceGite serviceGite;

    @PostConstruct
    private void init() {
allLocalites = serviceGite.getLocaliteFiltre();
    }

    public GiteBean(){
        serviceGite = new ServiceGite();
    }

    public ArrayList<Localite> getAllLocalites() {
        return allLocalites;
    }

    public static void setAllLocalites(ArrayList<Localite> allLocalites) {
        GiteBean.allLocalites = allLocalites;
    }

    public Localite getLocaliteSelected() {
        return localiteSelected;
    }

    public void setLocaliteSelected(Localite localiteSelected) {
        this.localiteSelected = localiteSelected;
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
}
