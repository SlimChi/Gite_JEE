package fr.cs.gite_jee.converter;

        import fr.cs.gite_jee.bean.GiteBean;
        import fr.cs.gite_jee.metier.Localite;
        import fr.cs.gite_jee.metier.Ville;
        import jakarta.faces.component.UIComponent;
        import jakarta.faces.context.FacesContext;
        import jakarta.faces.convert.Converter;
        import jakarta.faces.convert.FacesConverter;
        import jakarta.inject.Inject;

@FacesConverter(value = "localiteConverter", managed = true)
public class LocaliteConverter implements Converter {

    @Inject
    private GiteBean giteBean;

    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && value.trim().length() > 0){
            for (Localite localite : giteBean.getAllLocalites()){
                if(localite.getId() == Integer.parseInt(value)){
                    return localite;
                }
            }
        }
        return null;
    }


    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Localite localite = (Localite) object;
        return String.valueOf(localite.getId());
    }
}
