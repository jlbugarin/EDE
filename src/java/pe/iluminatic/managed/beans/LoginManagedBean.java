/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.iluminatic.managed.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author JBugarinP
 */
@ManagedBean
@RequestScoped
public class LoginManagedBean {

    private String usuario;
    private String password;
    private boolean signed;
    
    /**
     * Creates a new instance of LoginManagedBean
     */
    public LoginManagedBean() {
    }
    
    public String login(){
    
        System.out.println("constructor...");
        setSigned(true);
        return "template";
    }

    public String cancelar(){
        
        setSigned(false);
        System.out.println("cancelar...");
        return "index1";
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
