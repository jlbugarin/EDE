/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.iluminatic.session.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.iluminatic.dao.entidades.EdeOportunidades;

/**
 *
 * @author jlbugarin
 */
@Stateless
public class EdeOportunidadesFacade extends AbstractFacade<EdeOportunidades> {
    @PersistenceContext(unitName = "EDEPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EdeOportunidadesFacade() {
        super(EdeOportunidades.class);
    }
    
}