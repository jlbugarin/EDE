package pe.iluminatic.jsf.classes;

import pe.iluminatic.dao.entidades.EdeEval;
import pe.iluminatic.jsf.classes.util.JsfUtil;
import pe.iluminatic.jsf.classes.util.JsfUtil.PersistAction;
import pe.iluminatic.session.beans.EdeEvalFacade;

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

@ManagedBean(name = "edeEvalController")
@SessionScoped
public class EdeEvalController implements Serializable {

    @EJB
    private pe.iluminatic.session.beans.EdeEvalFacade ejbFacade;
    private List<EdeEval> items = null;
    private EdeEval selected;

    public EdeEvalController() {
    }

    public EdeEval getSelected() {
        return selected;
    }

    public void setSelected(EdeEval selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setEdeEvalPK(new pe.iluminatic.dao.entidades.EdeEvalPK());
    }

    private EdeEvalFacade getFacade() {
        return ejbFacade;
    }

    public EdeEval prepareCreate() {
        selected = new EdeEval();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EdeEvalCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EdeEvalUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EdeEvalDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<EdeEval> getItems() {
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

    public List<EdeEval> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<EdeEval> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = EdeEval.class)
    public static class EdeEvalControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EdeEvalController controller = (EdeEvalController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "edeEvalController");
            return controller.getFacade().find(getKey(value));
        }

        pe.iluminatic.dao.entidades.EdeEvalPK getKey(String value) {
            pe.iluminatic.dao.entidades.EdeEvalPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new pe.iluminatic.dao.entidades.EdeEvalPK();
            key.setIdEvaluacion(Integer.parseInt(values[0]));
            key.setCodEvaluador(values[1]);
            key.setTipoEvaluacion(values[2]);
            key.setRolEvaluacion(values[3]);
            key.setCodEvaluado(values[4]);
            return key;
        }

        String getStringKey(pe.iluminatic.dao.entidades.EdeEvalPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdEvaluacion());
            sb.append(SEPARATOR);
            sb.append(value.getCodEvaluador());
            sb.append(SEPARATOR);
            sb.append(value.getTipoEvaluacion());
            sb.append(SEPARATOR);
            sb.append(value.getRolEvaluacion());
            sb.append(SEPARATOR);
            sb.append(value.getCodEvaluado());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof EdeEval) {
                EdeEval o = (EdeEval) object;
                return getStringKey(o.getEdeEvalPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), EdeEval.class.getName()});
                return null;
            }
        }

    }

}
