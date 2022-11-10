package fr.cs.gite_jee.converter;

import fr.cs.gite_jee.bean.GiteBean;
import fr.cs.gite_jee.metier.Departement;
import fr.cs.gite_jee.metier.Equipement;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value = "departementConverter", managed = true)
public class DepartementConverter implements Converter {

    @Inject
    private GiteBean giteBean;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s != null && s.trim().length() > 0){
            for (Departement departement : giteBean.getAllDepartement()){
                if(departement.getCodeInseeDept().equals(s)){
                    return departement;
                }
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        Departement departement = (Departement) o;
        return String.valueOf(departement.getCodeInseeDept());
    }
}
