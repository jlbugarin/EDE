/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.iluminatic.session.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.iluminatic.dao.entidades.EdemPeriodo;

/**
 *
 * @author JBugarinP
 */
@Stateless
public class EdemPeriodoFacade extends AbstractFacade<EdemPeriodo> {
    @PersistenceContext(unitName = "EDEPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EdemPeriodoFacade() {
        super(EdemPeriodo.class);
    }
    
}
