package pe.iluminatic.jsf.classes;

import pe.iluminatic.dao.entidades.EdeCompetencias;
import pe.iluminatic.jsf.classes.util.JsfUtil;
import pe.iluminatic.jsf.classes.util.JsfUtil.PersistAction;
import pe.iluminatic.session.beans.EdeCompetenciasFacade;

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

@ManagedBean(name = "edeCompetenciasController")
@SessionScoped
public class EdeCompetenciasController implements Serializable {

    @EJB
    private pe.iluminatic.session.beans.EdeCompetenciasFacade ejbFacade;
    private List<EdeCompetencias> items = null;
    private EdeCompetencias selected;

    public EdeCompetenciasController() {
    }

    public EdeCompetencias getSelected() {
        return selected;
    }

    public void setSelected(EdeCompetencias selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setEdeCompetenciasPK(new pe.iluminatic.dao.entidades.EdeCompetenciasPK());
    }

    private EdeCompetenciasFacade getFacade() {
        return ejbFacade;
    }

    public EdeCompetencias prepareCreate() {
        selected = new EdeCompetencias();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EdeCompetenciasCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EdeCompetenciasUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EdeCompetenciasDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<EdeCompetencias> getItems() {
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

    public List<EdeCompetencias> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<EdeCompetencias> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = EdeCompetencias.class)
    public static class EdeCompetenciasControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EdeCompetenciasController controller = (EdeCompetenciasController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "edeCompetenciasController");
            return controller.getFacade().find(getKey(value));
        }

        pe.iluminatic.dao.entidades.EdeCompetenciasPK getKey(String value) {
            pe.iluminatic.dao.entidades.EdeCompetenciasPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new pe.iluminatic.dao.entidades.EdeCompetenciasPK();
            key.setIdEvaluacion(Integer.parseInt(values[0]));
            key.setItem(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(pe.iluminatic.dao.entidades.EdeCompetenciasPK value) {
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
            if (object instanceof EdeCompetencias) {
                EdeCompetencias o = (EdeCompetencias) object;
                return getStringKey(o.getEdeCompetenciasPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), EdeCompetencias.class.getName()});
                return null;
            }
        }

    }

}
