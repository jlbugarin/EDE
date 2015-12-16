/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.iluminatic.session.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.iluminatic.dao.entidades.EdemRolEval;

/**
 *
 * @author JBugarinP
 */
@Stateless
public class EdemRolEvalFacade extends AbstractFacade<EdemRolEval> {
    @PersistenceContext(unitName = "EDEPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EdemRolEvalFacade() {
        super(EdemRolEval.class);
    }
    
}
