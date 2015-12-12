package pe.iluminatic.jsf.classes;

import pe.iluminatic.dao.entidades.EdeOportunidades;
import pe.iluminatic.jsf.classes.util.JsfUtil;
import pe.iluminatic.jsf.classes.util.JsfUtil.PersistAction;
import pe.iluminatic.session.beans.EdeOportunidadesFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@ManagedBean(name = "edeOportunidadesController")
@SessionScoped
public class EdeOportunidadesController implements Serializable {

    @EJB
    private pe.iluminatic.session.beans.EdeOportunidadesFacade ejbFacade;
    private List<EdeOportunidades> items = null;
    private EdeOportunidades selected;

    public EdeOportunidadesController() {
    }

    public EdeOportunidades getSelected() {
        return selected;
    }

    public void setSelected(EdeOportunidades selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setEdeOportunidadesPK(new pe.iluminatic.dao.entidades.EdeOportunidadesPK());
    }

    private EdeOportunidadesFacade getFacade() {
        return ejbFacade;
    }

    public EdeOportunidades prepareCreate() {
        selected = new EdeOportunidades();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EdeOportunidadesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EdeOportunidadesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EdeOportunidadesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<EdeOportunidades> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public List<EdeOportunidades> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<EdeOportunidades> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = EdeOportunidades.class)
    public static class EdeOportunidadesControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EdeOportunidadesController controller = (EdeOportunidadesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "edeOportunidadesController");
            return controller.getFacade().find(getKey(value));
        }

        pe.iluminatic.dao.entidades.EdeOportunidadesPK getKey(String value) {
            pe.iluminatic.dao.entidades.EdeOportunidadesPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new pe.iluminatic.dao.entidades.EdeOportunidadesPK();
            key.setIdEvaluacion(Integer.parseInt(values[0]));
            key.setItem(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(pe.iluminatic.dao.entidades.EdeOportunidadesPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdEvaluacion());
            sb.append(SEPARATOR);
            sb.append(value.getItem());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof EdeOportunidades) {
                EdeOportunidades o = (EdeOportunidades) object;
                return getStringKey(o.getEdeOportunidadesPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), EdeOportunidades.class.getName()});
                return null;
            }
        }

    }

}
