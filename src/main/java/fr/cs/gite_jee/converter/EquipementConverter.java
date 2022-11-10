package fr.cs.gite_jee.converter;

import fr.cs.gite_jee.bean.GiteBean;
import fr.cs.gite_jee.metier.Equipement;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value = "equipementConverter", managed = true)
public class EquipementConverter implements Converter {

    @Inject
    private GiteBean giteBean;

    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){
            for (Equipement equipement : giteBean.getAllEquipements()){
                if(equipement.getId() == Integer.parseInt(value)){
                    return equipement;
                }
            }
        }
        return null;
    }


    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Equipement equipement = (Equipement) object;
        return String.valueOf(equipement.getId());
    }
}
