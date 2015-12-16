package pe.iluminatic.jsf.classes;

import pe.iluminatic.dao.entidades.EdemNivelEval;
import pe.iluminatic.jsf.classes.util.JsfUtil;
import pe.iluminatic.jsf.classes.util.JsfUtil.PersistAction;
import pe.iluminatic.session.beans.EdemNivelEvalFacade;

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

@ManagedBean(name = "edemNivelEvalController")
@SessionScoped
public class EdemNivelEvalController implements Serializable {

    @EJB
    private pe.iluminatic.session.beans.EdemNivelEvalFacade ejbFacade;
    private List<EdemNivelEval> items = null;
    private EdemNivelEval selected;

    public EdemNivelEvalController() {
    }

    public EdemNivelEval getSelected() {
        return selected;
    }

    public void setSelected(EdemNivelEval selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private EdemNivelEvalFacade getFacade() {
        return ejbFacade;
    }

    public EdemNivelEval prepareCreate() {
        selected = new EdemNivelEval();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EdemNivelEvalCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EdemNivelEvalUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EdemNivelEvalDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<EdemNivelEval> getItems() {
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

    public List<EdemNivelEval> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<EdemNivelEval> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = EdemNivelEval.class)
    public static class EdemNivelEvalControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EdemNivelEvalController controller = (EdemNivelEvalController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "edemNivelEvalController");
            return controller.getFacade().find(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof EdemNivelEval) {
                EdemNivelEval o = (EdemNivelEval) object;
                return getStringKey(o.getCodRespuesta());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), EdemNivelEval.class.getName()});
                return null;
            }
        }

    }

}
