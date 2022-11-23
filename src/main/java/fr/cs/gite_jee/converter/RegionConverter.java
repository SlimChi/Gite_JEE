package fr.cs.gite_jee.converter;


import fr.cs.gite_jee.bean.GiteBean;
import fr.cs.gite_jee.metier.Region;
import fr.cs.gite_jee.metier.Ville;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value = "regionConverter" , managed = true)
public class RegionConverter implements Converter {

    @Inject
    private GiteBean giteBean;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){
            for (Region region: giteBean.getAllRegion()){
                if(region.getId() == Integer.parseInt(value)){
                    return region;
                }
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Region region = (Region) object;
        return String.valueOf(region.getId());
    }
}
