package pe.iluminatic.jsf.classes;

import pe.iluminatic.dao.entidades.EdeCompromisos;
import pe.iluminatic.jsf.classes.util.JsfUtil;
import pe.iluminatic.jsf.classes.util.JsfUtil.PersistAction;
import pe.iluminatic.session.beans.EdeCompromisosFacade;

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

@ManagedBean(name = "edeCompromisosController")
@SessionScoped
public class EdeCompromisosController implements Serializable {

    @EJB
    private pe.iluminatic.session.beans.EdeCompromisosFacade ejbFacade;
    private List<EdeCompromisos> items = null;
    private EdeCompromisos selected;

    public EdeCompromisosController() {
    }

    public EdeCompromisos getSelected() {
        return selected;
    }

    public void setSelected(EdeCompromisos selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setEdeCompromisosPK(new pe.iluminatic.dao.entidades.EdeCompromisosPK());
    }

    private EdeCompromisosFacade getFacade() {
        return ejbFacade;
    }

    public EdeCompromisos prepareCreate() {
        selected = new EdeCompromisos();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EdeCompromisosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EdeCompromisosUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EdeCompromisosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<EdeCompromisos> getItems() {
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

    public List<EdeCompromisos> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<EdeCompromisos> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = EdeCompromisos.class)
    public static class EdeCompromisosControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EdeCompromisosController controller = (EdeCompromisosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "edeCompromisosController");
            return controller.getFacade().find(getKey(value));
        }

        pe.iluminatic.dao.entidades.EdeCompromisosPK getKey(String value) {
            pe.iluminatic.dao.entidades.EdeCompromisosPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new pe.iluminatic.dao.entidades.EdeCompromisosPK();
            key.setIdEvaluacion(Integer.parseInt(values[0]));
            key.setItem(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(pe.iluminatic.dao.entidades.EdeCompromisosPK value) {
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
            if (object instanceof EdeCompromisos) {
                EdeCompromisos o = (EdeCompromisos) object;
                return getStringKey(o.getEdeCompromisosPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), EdeCompromisos.class.getName()});
                return null;
            }
        }

    }

}
