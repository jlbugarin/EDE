/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.iluminatic.managed.beans;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import pe.iluminatic.dao.entidades.UserRoles;
import pe.iluminatic.dao.entidades.Users;

/**
 *
 * @author JBugarinP
 */
@ManagedBean
@SessionScoped
public class LoginManagedBean implements Serializable {

    private String usuario;
    private String password;
    private boolean signed;

    @EJB
    private pe.iluminatic.session.beans.UsersFacade ejbFacade;
    @EJB
    private pe.iluminatic.session.beans.UserRolesFacade ejbRoleFacade;

    /**
     * Creates a new instance of LoginManagedBean
     */
    public LoginManagedBean() {
    }

    public String login() {

        
        Users user = new Users();
        user.setPassword(this.password.trim());
        user.setUsername(this.usuario.trim());

        Users userBd = ejbFacade.find(user.getUsername());

        String direccionPagina = "/pages/template";

        if (userBd != null) {

            if ((userBd.getPassword().equals(user.getPassword())) && (userBd.getUsername().equals(user.getUsername())) && (userBd.getEnabled() == 1)) {

                setSigned(true);
                
                //obtener los permisos
               // UserRoles roles = ejbRoleFacade.(1);
                
                //ejbRoleFacade.find(UserRoles.class,);
                List listaRoles = ejbRoleFacade.findRol(userBd);
                listaRoles.size();

            } else {

                direccionPagina = "login";
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El password no existe"));
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El usuario no existe"));
            direccionPagina = "login";

        }

        return direccionPagina;

    }

    public String cancelar() {

        setSigned(false);
        System.out.println("cancelar...");
        return "login";
    }

    public String logout() {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();

        HttpSession session = (HttpSession) externalContext.getSession(true);
        session.removeAttribute("loginManagedBean");
        session.invalidate();

        return "/login.xhtml";

    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the signed
     */
    public boolean isSigned() {
        return signed;
    }

    /**
     * @param signed the signed to set
     */
    public void setSigned(boolean signed) {
        this.signed = signed;
    }

}
