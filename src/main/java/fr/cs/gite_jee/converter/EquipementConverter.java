package fr.cs.gite_jee.converter;

import fr.cs.gite_jee.bean.GiteBean;
import fr.cs.gite_jee.metier.Ville;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value = "villeConverter", managed = true)
public class VilleConverter implements Converter {

    @Inject
    private GiteBean giteBean;

    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){
            for (Ville ville : giteBean.getAllVilles()){
                if(ville.getNom() == value){
                    return ville;
                }
            }
        }
        return null;
    }


    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Ville ville = (Ville) object;
        return String.valueOf(ville.getNom());
    }
}
