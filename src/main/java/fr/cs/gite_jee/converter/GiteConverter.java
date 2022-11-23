package fr.cs.gite_jee.converter;

import fr.cs.gite_jee.bean.GiteBean;
import fr.cs.gite_jee.metier.Equipement;
import fr.cs.gite_jee.metier.Gite;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;


@FacesConverter(value = "giteConverter", managed = true)
public class GiteConverter implements Converter {

    @Inject
    private GiteBean giteBean;

    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){
            for (Gite gite : giteBean.getAllGites()){
                if(gite.getId() == Integer.parseInt(value)){
                    return gite;
                }
            }
        }
        return null;
    }

    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Gite gite = (Gite) object;
        return String.valueOf(gite.getId());
    }
}
