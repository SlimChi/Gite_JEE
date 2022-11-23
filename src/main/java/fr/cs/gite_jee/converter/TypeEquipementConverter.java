package fr.cs.gite_jee.converter;

import fr.cs.gite_jee.bean.GiteBean;
import fr.cs.gite_jee.metier.Equipement;
import fr.cs.gite_jee.metier.TypeEquipement;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value = "typeEquipementConverter", managed = true)
public class TypeEquipementConverter implements Converter {

    @Inject
    private GiteBean giteBean;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){
            for (TypeEquipement typeEquipement : giteBean.getAllTypeEquipements()){
                if(typeEquipement.getId() == Integer.parseInt(value)){
                    return typeEquipement;
                }
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
       TypeEquipement typeEquipement = (TypeEquipement) object;
       return String.valueOf(typeEquipement.getId());
    }
}
