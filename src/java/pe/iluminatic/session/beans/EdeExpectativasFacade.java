/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.iluminatic.session.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.iluminatic.dao.entidades.EdeExpectativas;

/**
 *
 * @author jlbugarin
 */
@Stateless
public class EdeExpectativasFacade extends AbstractFacade<EdeExpectativas> {
    @PersistenceContext(unitName = "EDEPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EdeExpectativasFacade() {
        super(EdeExpectativas.class);
    }
    
}
