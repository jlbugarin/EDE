package pe.iluminatic.jsf.classes;

import pe.iluminatic.dao.entidades.EdemEvaluadosConf;
import pe.iluminatic.jsf.classes.util.JsfUtil;
import pe.iluminatic.jsf.classes.util.JsfUtil.PersistAction;
import pe.iluminatic.session.beans.EdemEvaluadosConfFacade;

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

@ManagedBean(name = "edemEvaluadosConfController")
@SessionScoped
public class EdemEvaluadosConfController implements Serializable {

    @EJB
    private pe.iluminatic.session.beans.EdemEvaluadosConfFacade ejbFacade;
    private List<EdemEvaluadosConf> items = null;
    private EdemEvaluadosConf selected;

    public EdemEvaluadosConfController() {
    }

    public EdemEvaluadosConf getSelected() {
        return selected;
    }

    public void setSelected(EdemEvaluadosConf selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setEdemEvaluadosConfPK(new pe.iluminatic.dao.entidades.EdemEvaluadosConfPK());
    }

    private EdemEvaluadosConfFacade getFacade() {
        return ejbFacade;
    }

    public EdemEvaluadosConf prepareCreate() {
        selected = new EdemEvaluadosConf();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EdemEvaluadosConfCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EdemEvaluadosConfUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EdemEvaluadosConfDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<EdemEvaluadosConf> getItems() {
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

    public List<EdemEvaluadosConf> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<EdemEvaluadosConf> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = EdemEvaluadosConf.class)
    public static class EdemEvaluadosConfControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EdemEvaluadosConfController controller = (EdemEvaluadosConfController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "edemEvaluadosConfController");
            return controller.getFacade().find(getKey(value));
        }

        pe.iluminatic.dao.entidades.EdemEvaluadosConfPK getKey(String value) {
            pe.iluminatic.dao.entidades.EdemEvaluadosConfPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new pe.iluminatic.dao.entidades.EdemEvaluadosConfPK();
            key.setTipoEvaluacion(values[0]);
            key.setCodEvaluado(values[1]);
            return key;
        }

        String getStringKey(pe.iluminatic.dao.entidades.EdemEvaluadosConfPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getTipoEvaluacion());
            sb.append(SEPARATOR);
            sb.append(value.getCodEvaluado());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof EdemEvaluadosConf) {
                EdemEvaluadosConf o = (EdemEvaluadosConf) object;
                return getStringKey(o.getEdemEvaluadosConfPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), EdemEvaluadosConf.class.getName()});
                return null;
            }
        }

    }

}
